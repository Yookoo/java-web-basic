package com.edu.gradle.repository;

import com.edu.gradle.model.ToDoItem;
import com.edu.gradle.utils.JDBCUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ToDoRepository 基于 H2的实现
 * Created by Administrator on 2017/11/22.
 */
public class H2ToDoRepository implements ToDoRepository {

    private static final String SQL_FIND_ALL = "SELECT id,name,completed FROM todo_item;";
    private static final String SQL_FIND_BY_ID = "SELECT id,name,completed FROM todo_item WHERE id = ?;";
    //private static final String SQL_CREATE = "CREATE TABLE todo_item (id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(255), completed TINYINT(1));";
    private static final String SQL_INSERT = "INSERT INTO todo_item (name, completed) VALUES(?, ?);";
    private static final String SQL_UPDATE = "UPDATE todo_item SET name=?, completed= ? WHERE ID=?;";
    private static final String SQL_DELETE = "delete from todo_item where id = ? ;";

    /**
     * 查询所有 ToDoItem
     *
     * @return list
     */

    @Override
    public List<ToDoItem> findAll() {
        List<ToDoItem> list = new ArrayList<>();
        List<Map<String, Object>> maps = new ArrayList<>();
        Connection connection = null;

        try {
            connection = JDBCUtil.getH2Connection();
            maps = JDBCUtil.executeQueryList(connection, SQL_FIND_ALL, null);
            for (Map<String, Object> map : maps) {
            	ToDoItem item = this.changeMapToTodoItem(map);
            	list.add(item);
			}
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
        return list;
    }
    
    /**
     * 根据id查询
     * 
     * @param id
     * @return 
     */
  
    @Override
    public ToDoItem findById(Long id) {

        Connection connection = null;
        ToDoItem toDoItem = new ToDoItem();

        List<Object> prarms = new ArrayList<>();
        prarms.add(id);

        try {
            connection = JDBCUtil.getH2Connection();
            Map<String,Object> map = JDBCUtil.executeQueryOne(connection, SQL_FIND_BY_ID, prarms);
            toDoItem = changeMapToTodoItem(map);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection);
        }
        return toDoItem;
    }

    /**
     * 查询 TodoItem
     * @param toDoItem
     */
    @Override
    public Long insert(ToDoItem toDoItem) {
        Connection connection = null;
        Long key = 0L;
        List<Object> prarms = new ArrayList<>();
        prarms.add(toDoItem.getName());
        prarms.add(toDoItem.isCompleted());
        try {
            connection = JDBCUtil.getH2Connection();
            key = JDBCUtil.executeInsert(connection, SQL_INSERT, prarms);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection);
        }
        return key;
    }
    /**
     * 更新 toDoItem
     * @param toDoItem
     */

	@Override
    public void update(ToDoItem toDoItem) {
        Connection connection = null;
        List<Object> prarms = new ArrayList<>();
        prarms.add(toDoItem.getName());
        prarms.add(toDoItem.isCompleted());
        prarms.add(toDoItem.getId());
        try {
            connection = JDBCUtil.getH2Connection();
            JDBCUtil.executeUpdateOrDelete(connection, SQL_UPDATE, prarms);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection);
        }
    }

    @Override
    public void delete(ToDoItem toDoItem) {
        Connection connection = null;
        List<Object> prarms = new ArrayList<>();
        prarms.add(toDoItem.getId());
        try {
            connection = JDBCUtil.getH2Connection();
            JDBCUtil.executeUpdateOrDelete(connection, SQL_DELETE, prarms);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection);
        }
    }
    /**
     * 将map类型的实例转换为ToDoitem（待优化为一个通用的方法）
     * @param map
     * @return
     */
    private ToDoItem changeMapToTodoItem(Map<String,Object> map) {
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setId((Long) map.get("ID"));
        toDoItem.setName((String) map.get("NAME"));
        Integer completed = Integer.valueOf(String.valueOf(map.get("COMPLETED")));
        toDoItem.setCompleted(completed == 1 ? true : false);
        return toDoItem;
    }

}
