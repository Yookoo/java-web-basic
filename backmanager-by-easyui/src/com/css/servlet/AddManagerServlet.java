package com.css.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.css.domain.User;
import com.css.service.UserService;
import com.css.utils.DateUtils;

public class AddManagerServlet extends HttpServlet {

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
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setAuthority(request.getParameter("authority"));
		user.setRegdate(DateUtils.FormatDate(new Date(), "yyyy-MM-dd hh:mm:ss"));
	
		UserService service = new UserService();
		int rows = service.addUser(user);
		out.print(rows);
		
		out.flush();
		out.close();
	}

}
