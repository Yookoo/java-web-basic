package com.css.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.css.domain.Navigation;
import com.css.service.NavigationService;

public class NavigationServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String temp = request.getParameter("id");
		String id = (temp != null && temp.length()> 0) ? temp : "0"; 
		System.out.println("id："+ id );
		NavigationService  navigationServlce = new NavigationService();
		List<Navigation> navigationList = navigationServlce.findByNid(id);
		
		String navigations = JSON.toJSONString(navigationList);
		//System.out.println(navigations);
		out.print(navigations);
		
		out.flush();
		out.close();
	}

}
