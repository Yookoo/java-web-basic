package com.css.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.css.domain.User;
import com.css.utils.SqlHelper;

public class UserService {
	
	public String findRowNumber(String name,String date_from,String date_to){
		
		StringBuffer sqlBuffer = new StringBuffer("SELECT count(*) FROM users WHERE 1=1");
		
		if(!(name == null || name.length() <= 0)){
			//濡傛灉瀛樺湪鍚慡tringBuffer涓拷鍔爏ql璇彞
			sqlBuffer.append(" AND NAME LIKE '%"+name+"%'");
		}
		
		if(!(date_from == null || date_from.length() <= 0)){
			//濡傛灉瀛樺湪鍚慡tringBuffer涓拷鍔爏ql璇彞
			sqlBuffer.append(" AND regdate >= '"+date_from+"'");
		}
		
		if(!(date_to == null || date_to.length() <= 0)){
			//濡傛灉瀛樺湪鍚慡tringBuffer涓拷鍔爏ql璇彞
			sqlBuffer.append(" AND regdate <= '"+date_to+"'");
		}
		
		String sql = sqlBuffer.append(";").toString();
		
		//System.out.println(sql);
		
		ResultSet rs = SqlHelper.executeQuery(sql, null);
		String rowNumber = null;
		try {
			while(rs.next()) {
			rowNumber =  rs.getString(1);		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowNumber;
	}
	

	
		//	SELECT 
		//	  NAME,
		//	  email,
		//	  regdate 
		//	FROM
		//	  users 
		//	WHERE 1 = 1 
		//	  AND NAME LIKE '%%' 
		//	  AND regdate >= '20161201' 
		//	  AND regdate <= '20171212' 
		//	ORDER BY regdate ASC 
		//	LIMIT 0, 10 
	
	public String findAllByPage(String name,String date_from,String date_to,String sortName,String order,int first, int pageSize) {

		//鎷煎啓SQL璇彞
		StringBuffer sqlBuffer = new StringBuffer("SELECT id,name,email,regdate FROM users WHERE 1=1");
		//鍒ゆ柇name鏄惁瀛樺湪
		if(!(name == null || name.length() <= 0)){
			//濡傛灉瀛樺湪鍚慡tringBuffer涓拷鍔爏ql璇彞
			sqlBuffer.append(" AND NAME LIKE '%"+name+"%'");
		}
		
		if(!(date_from == null || date_from.length() <= 0)){
			//濡傛灉瀛樺湪鍚慡tringBuffer涓拷鍔爏ql璇彞
			sqlBuffer.append(" AND regdate >= '"+date_from+"'");
		}
		
		if(!(date_to == null || date_to.length() <= 0)){
			//濡傛灉瀛樺湪鍚慡tringBuffer涓拷鍔爏ql璇彞
			sqlBuffer.append(" AND regdate <= '"+date_to+"'");
		}
		//璁剧疆鎺掑簭
		if((!(sortName == null || sortName.length() <= 0))&& ("ASC".equals(order)||"DESC".equals(order))){
			//濡傛灉瀛樺湪鍚慡tringBuffer涓拷鍔爏ql璇彞
			sqlBuffer.append(" ORDER BY "+sortName+" "+order);
		}
	
		if(first >= 0 && pageSize >0){
			sqlBuffer.append(" LIMIT "+first+", "+ pageSize );
			
		}
		
		String sql = sqlBuffer.append(";").toString();
		//System.out.println(sql);
		ResultSet rs = SqlHelper.executeQuery(sql, null);
		List<User> users = new ArrayList<User>();
		try {
			while(rs.next()){
				User u = new User();
				u.setId(rs.getString(1));
				u.setName(rs.getString(2));	
				u.setEmail(rs.getString(3));	
				u.setRegdate(rs.getString(4));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(users);
	}



	public int removeUserById(String ids) {
		String sql ="DELETE FROM users WHERE id IN("+ids+");";
		int rows = SqlHelper.executeUpdate(sql, null);
		return rows;
	}



	public int addUser(User u) {
		String sql ="INSERT INTO users(NAME, email, regdate) VALUES ('"+u.getName()+"', '"+u.getEmail()+"', '"+u.getRegdate()+"');";
		System.out.println(sql);
		int rows = SqlHelper.executeUpdate(sql, null);
		return rows;
	}



	public int updateUser(User u) {
		
		String sql = "UPDATE users SET NAME = '"+u.getName()+"', regdate = '"+u.getRegdate()+"', email = '"+u.getEmail()+"' WHERE id = "+u.getId()+";" ;
		System.out.println(sql);
		int rows = SqlHelper.executeUpdate(sql, null);
		return rows;
	}
}
