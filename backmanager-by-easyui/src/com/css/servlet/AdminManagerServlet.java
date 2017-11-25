package com.css.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.css.service.UserService;

public class AdminManagerServlet extends HttpServlet {

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
		//session校验
//		User user = (User) request.getSession().getAttribute("loginInfo");	
//		if(user == null ){	
//			request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
//		}

		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int first = pageSize * (page - 1);
		
		String name = request.getParameter("name");
		String date_from = request.getParameter("date_from");
		String date_to = request.getParameter("date_to");

		//通过服务器排序时用到
		String order = request.getParameter("order").toUpperCase();
		String sortName = request.getParameter("sort");
		//System.out.println(name+","+date_from+","+date_to);
		
		UserService service = new UserService();
		String total = service.findRowNumber(name, date_from, date_to);
		String rows = service.findAllByPage(name, date_from, date_to, sortName, order, first, pageSize);
		System.out.println(total);		
		//发送响应
		out.println("{\"total\":"+total+",\"rows\":"+rows+"}");
		out.flush();
		out.close();
	}

}
