<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">

  </head>
  
  <body bgcolor="#DDDDFF">
  	<center>
 	 <h1>我的聊天室</h1>
     <form action="${pageContext.request.contextPath}/login.do?flag=login" method="post">
     	用户:<input type="text" name="name"><br>
     	密码:<input type="password" name="password"><br>
     	<input type="submit" value="登录">
     </form>
     </center>
  </body>
</html>
