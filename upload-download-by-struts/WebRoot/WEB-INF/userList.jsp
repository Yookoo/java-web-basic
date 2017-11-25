<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>用户列表</h1><br>
    <table border="1">
    <tr>
	<td>用户名</td>    
	<td>头像</td>
	<td>下载头像</td>
    </tr>
    <c:forEach items="${userList }" var="user">
    <tr>
	<td>${user.username }</td>    
	<td><img src="/strutsUpAndDown/file/${user.uuidname }" width="50px"/></td>
	<td><a href="/strutsUpAndDown/user.do?flag=downFile&username=${user.username }">点击下载</a></td>
    </tr>
    </c:forEach>
    </table>
  </body>
</html>
