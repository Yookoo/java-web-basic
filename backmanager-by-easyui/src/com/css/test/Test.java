package com.css.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.css.domain.User;
import com.css.utils.SqlHelper;

public class Test {

	public static void main(String[] args) {
		String sql = "SELECT name,email,regdate FROM users;";
		ResultSet rs = SqlHelper.executeQuery(sql, null);
		List<User> users = new ArrayList<User>();
		try {
			while(rs.next()){
				User u = new User();
				u.setName(rs.getString(1));	
				u.setEmail(rs.getString(2));	
				u.setRegdate(rs.getString(3));
				users.add(u);
			}
			String jsonString = JSON.toJSONString(users);
			System.out.println(jsonString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
