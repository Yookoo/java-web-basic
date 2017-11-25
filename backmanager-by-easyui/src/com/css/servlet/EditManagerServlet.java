package com.css.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.css.domain.User;
import com.css.service.UserService;

public class EditManagerServlet extends HttpServlet {

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
		
		String id = request.getParameter("id");
		System.out.println(id);
		UserService userService = new UserService();
		User user =  userService.findUserById(id);
		
		String password = request.getParameter("password");
		if(password != null && password.length() > 0){
			user.setPassword(password);
		};
		
		String email = request.getParameter("email");
		if(email != null && email.length() > 0){
			user.setEmail(email);
		};
		
		String authority = request.getParameter("authority");
		if(authority != null && authority.length() > 0){
			user.setAuthority(authority);
		};
		
		int rows = userService.updateUser(user);
 
		out.print(rows);
		out.flush();
		out.close();
	}

}
