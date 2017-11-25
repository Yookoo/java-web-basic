package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.SqlHelper;
import domain.User;

public class UserService {
	// 添加用户的方法
	@SuppressWarnings("static-access")
	public boolean addUser(User user) {
		SqlHelper sqlHelper = new SqlHelper();
		String sql = "INSERT INTO USER(username,filename,uuidname) VALUES(?,?,?);";
		String[] parameters = { user.getUsername(), user.getFilename(),
				user.getUuidname() };
		sqlHelper.executeUpdate(sql, parameters);
		return true;
	}

	@SuppressWarnings("static-access")
	public ArrayList<User> findAllUser() {
		// TODO Auto-generated method stub
		ArrayList<User> al = new ArrayList<User>();		
		SqlHelper sqlHelper = new SqlHelper();
		String sql = "select * from USER;";
		ResultSet rs = sqlHelper.executeQuery(sql, null); 
		 try {
				 while(rs.next()){
				 User user = new User();
				 user.setUsername(rs.getString("username"));
				 user.setFilename(rs.getString("filename"));
				 user.setUuidname(rs.getString("uuidname"));
				 al.add(user);
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		return al;
	}

	@SuppressWarnings("static-access")
	public User findUser(String username) {
		// TODO Auto-generated method stub
		SqlHelper sqlHelper = new SqlHelper();
		String sql = "select * from USER where username = ?";
		String[] parameters = { username };
		ResultSet rs = sqlHelper.executeQuery(sql, parameters); 
		User user = new User();
		try {
			while(rs.next()){
			user.setUsername(rs.getString("username"));
			user.setFilename(rs.getString("filename"));
			user.setUuidname(rs.getString("uuidname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		System.out.println(user.getUsername()+"-"+user.getFilename()+"-"+user.getUuidname());
		return user;
	}
}
