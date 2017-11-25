package com.css.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.css.domain.User;

public class AdminServlet extends HttpServlet {


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
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");

		//session校验
		User user = (User) request.getSession().getAttribute("loginInfo");
		
		if(user == null ){	
			System.out.println("权限验证失败!!");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
		} else {
			System.out.println(user.getName());
			request.getRequestDispatcher("/jsp/admin.jsp").forward(request,response);
		}
		
		out.flush();
		out.close();
		
	}

}
