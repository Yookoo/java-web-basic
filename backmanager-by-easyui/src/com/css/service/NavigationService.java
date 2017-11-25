package com.css.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.css.domain.Navigation;

import com.css.utils.SqlHelper;

public class NavigationService {

	public List<Navigation> findByNid(String id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT id,text,state,iconCls,url,nid FROM nav WHERE nid = "+id+";";
//		System.out.println(sql);
		ResultSet rs = SqlHelper.executeQuery(sql, null);
		List<Navigation> navigationList = new ArrayList<Navigation>();
		try {
			while(rs.next()){
				Navigation navigation = new Navigation();
				navigation.setId(Integer.parseInt(rs.getString(1)));
				navigation.setText(rs.getString(2));	
				navigation.setState(rs.getString(3));	
				navigation.setIconCls(rs.getString(4));
				navigation.setUrl(rs.getString(5));
				navigation.setNid(Integer.parseInt(rs.getString(6)));
				navigationList.add(navigation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return navigationList;
	}

}
