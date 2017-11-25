<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/admin.js"></script>


  </head>
  
 
   <body class="easyui-layout">   
	  <div data-options="region:'north',title:'header',split:true,noheader:true" style="height:60px;background:#666;">
	  	<div class="logo">后台管理</div>
		<div class="logout">
			您好，${loginInfo.name} | <a href="${basePath }/LogoutServlet">退出</a>
		</div>
	  </div>    
	
	  <div data-options="region:'west',title:'导航',split:true,iconCls:'icon-world'" style="width:180px;padding:10px;">
	  	<ul id="nav"></ul>
	  </div>   
	  
	  <div data-options="region:'center',noheader:true" style="overflow:hidden;">
	  	<div id="tabs">
			<div title="起始页" iconCls="icon-home" style="padding:0 10px;display:block;">
				<p>欢迎来到后台管理系统！</p>
			</div>
		</div>  
	  </div>
	  
	  <div data-options="region:'south',title:'footer',split:true,noheader:true" style="height:35px;line-height:30px;text-align:center;">
	 	 ©2009-2015 瓢城Web 俱乐部. Powered by JAVA and EasyUI.
	  </div> 
   </body>  
</html>
