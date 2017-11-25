<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台管理系统</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 	
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	 -->	
  </head>
  
  <body>
  	<div id="adminManager"></div>
	<div id="toolbar" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true"  onclick="manager.add();">添加</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="manager.edit();">修改</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="manager.remove();">删除</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-reload" plain="true" id="save" onclick="manager.reload();">刷新</a>
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-redo" plain="true" id="redo" onclick="manager.redo();">取消</a>
		</div>
		<div style="padding:0 0 0 7px;">
			查询帐号： <input class="textbox" name="name" style="width:110px">
			注册时间从： <input class="easyui-datebox" name="date_from" style="width:110px">
			 到： <input class="easyui-datebox" name="date_to" style="width:110px">
			<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search" onclick="manager.search();">查询</a>
		</div>
	</div>
	
	<form id="manager_add" style="margin:0;padding:5px 0 0 25px;color:#333;">
		<p>管理帐号：<input class="textbox" style="width:200px;" type="text" name="username"/></p>
		<p>管理密码：<input class="textbox" style="width:200px;" type="password" name="password"/></p>
		<p>管理邮箱：<input class="textbox" style="width:200px;" type="text" name="email"/></p>
		<p>权限管理：<input style="width:205px;" type="text" id = "authority"/></p>
	</form>
	
	<form id="manager_edit" style="margin:0;padding:5px 0 0 25px;color:#333;">
		<input name="id_edit" type ="text" style="display:none;">
		<p>管理帐号：<input class="textbox" style="width:200px;" type="text" name="manager_edit" disabled="true"></p>
		<p>管理密码：<input class="textbox" style="width:200px;" type="password" name="password_edit"></p>
		<p>管理邮箱：<input class="textbox" style="width:200px;" type="text" name="email_edit"/></p>
		<p>权限管理：<input id="auth_edit" class="textbox" name="auth_edit" style="width:205px;"></p>
</form>
	<script type="text/javascript" src="js/adminManager.js"></script>
	
  </body>
</html>
