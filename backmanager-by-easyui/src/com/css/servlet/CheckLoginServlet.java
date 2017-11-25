package com.css.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.css.domain.User;
import com.css.service.UserService;

public class CheckLoginServlet extends HttpServlet {

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
		
		String manager = request.getParameter("manager"); 	
		String password = request.getParameter("password"); 	

		UserService service = new UserService();
		
		List<User> users = service.checkLogin(manager,password);
		if (users.size() > 0){
			HttpSession session = request.getSession();
			session.setAttribute("loginInfo", users.get(0));
			out.print(1);
			
		} else {
			out.print(0);
		}
		out.flush();
		out.close();
	}

}
