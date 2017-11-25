package test;



import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import service.ProvinceService;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProvinceService pService = new ProvinceService();
		List<Map<String,String>> map = pService.findProvince();
		
		JSONArray json = new JSONArray();
		String jprovince =json.fromObject(map).toString();

		System.out.println(jprovince);
		//}
		
	}

}
