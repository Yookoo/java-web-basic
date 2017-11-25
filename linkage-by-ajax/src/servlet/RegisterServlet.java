package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/xml");
		response.setHeader("Content-Type", "text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		//System.out.println("name:"+name );
		if(name==null||name==""||"shunping".equals(name)){
			//response.getWriter().print("<res><mes>对不起，该用户名不可用！</mes></res>");
			response.getWriter().print("{'mes':'对不起，该用户名不可用！','date':'2016-12-12'}");
			//System.out.println("该用户名不可用！");
		}else{
			response.getWriter().print("{'mes':'对不起，该用户名可用！','date':'2015-11-11'}");
			//System.out.println("该用户名可用！");
		}
	
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		this.doGet(request, response);
	}

}
