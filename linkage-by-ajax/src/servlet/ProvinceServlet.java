package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import service.ProvinceService;

public class ProvinceServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setHeader("Content-Type", "text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		
		response.setCharacterEncoding("utf-8");
		//String name = request.getParameter("name");
		
		ProvinceService pService = new ProvinceService();
		List<Map<String,String>> lists = pService.findProvince();
		
		JSONArray json = new JSONArray();
		String jprovince =json.fromObject(lists).toString();
		response.getWriter().print(jprovince);
	
	}

}
