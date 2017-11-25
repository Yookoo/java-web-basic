<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>管理员登陆</title>

<meta charset="UTF-8">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/login.js"></script>

</head>

<body>
	<div id='login'>
		<p>管理员帐号<input type="text" id='manager' class='textbox'></p>	
		<p>管理员密码<input type="password" id='password' class='textbox'></p>
	</div>
	<div id='btn'>
		<a class='easyui-linkbutton' id='loginok' >登录</a>
		<a class='easyui-linkbutton' id='loginerr' >重置</a>
	</div> 
</body>
</html>
