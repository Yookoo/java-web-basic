<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<h2>Index!</h2>
	<br>
	<!-- shiro:principal 表示认证之后的用户信息-->
	<shiro:user>
	 欢迎：<shiro:principal />
	</shiro:user>
	<shiro:guest>
		欢迎游客访问！
	</shiro:guest>
	<br>
	<shiro:authenticated>
	 用户：<shiro:principal /> 身份验证已通过（不包括记住密码）
	</shiro:authenticated>
	<shiro:notAuthenticated>
	 用户身份验证未通过，包括记住密码
	</shiro:notAuthenticated>

	<br> user跳转：
	<shiro:hasAnyRoles name="user,admin">
		<a href="/user.jsp">user.jsp</a>
	</shiro:hasAnyRoles>
	<shiro:lacksRole name="admin">
		<b>用户没有admin权限！</b>
	</shiro:lacksRole>
	<br>
	admin跳转：
	<shiro:hasAnyRoles name="admin">
	<a href="/admin.jsp">admin.jsp</a>
	</shiro:hasAnyRoles>
	<br>
	<a href="logout">logout</a>
</body>
</html>