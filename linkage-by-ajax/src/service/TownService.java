package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.SqlHelper;

public class TownService {

	public List findTown(String city){
		String sql="select id,name from town where cId=? order by id;";
		ResultSet rs = null;
		List<Map<String,String>> lists = new ArrayList<Map<String,String>>();
		
	try {
		rs = SqlHelper.executeQuery2(sql, city);
		while(rs.next()){
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", rs.getString("id").trim());
			map.put("name", rs.getString("name").trim());
			lists.add(map);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return lists;
}
}
