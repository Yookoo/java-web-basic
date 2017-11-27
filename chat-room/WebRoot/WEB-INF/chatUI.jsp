<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chatUI.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" language="javascript" src="js/myjs.js"></script>
	<script type="text/javascript" language="javascript" src="js/common.js"></script>
	<script type="text/javascript" language="javascript">
	var contextPath = "${pageContext.request.contextPath}";
	var gid =${getter.id };
	var sName = "${userInfo.name }";
	</script>
	
  </head>
  
  <body>
   <center>
   <h1>${userInfo.name }正在和${getter.name }聊天</h1>
   <textarea id="chatarea" rows="15" cols="50"></textarea><br/>
   <input type="text" id="chatext" style="width: 320">
   <input type="button" onclick="sendMessage()" value="发送">
   </center>
  </body>
</html>
