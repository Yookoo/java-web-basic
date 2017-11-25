<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" language="javascript">
	
	var xmlHttpRequest ="";
	var myXmlRequest= "";
	function getXMLHttpRequest(){
	try {
		xmlHttpRequest=new XMLHttpRequest();
	} catch (e) {
		xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
	}
		return xmlHttpRequest;
	}

	function checkName(){
		myXmlRequest = getXMLHttpRequest();
		if(myXmlRequest){
			var url = "/ajax_userCheck/registerServlet?name="+$("name").value;
			myXmlRequest.onreadystatechange=returnCheckName;
			myXmlRequest.open("get",url,true);
			//window.alert($("name"));
			myXmlRequest.send(null);
		}
	}
	function returnCheckName(){
		//window.alert("处理函数被调回"+myXmlRequest.responseText);
		//我要取出从registerPro.php页面返回的数据
		if(myXmlRequest.readyState==4){
			//取出值,根据返回信息的格式定.text
			//window.alert(myXmlRequest.responseText);

			//$("nameCheck").value =myXmlRequest.responseText;
			//var mes = myXmlRequest.responseXML.getElementsByTagName("mes");
			//看看如果取出 xml格式数据
			//取出mes节点值
			//window.alert(mes.length);
			//mes[0]->表示取出第一个mes节点
			//mes[0].childNodes[0]->表示第一个mes节点的第一个子节点
			//var mes_val=mes[0].childNodes[0].nodeValue;
			
			var mes = myXmlRequest.responseText;
			mes_obj=eval("("+mes+")");
			$("nameCheck").value= mes_obj.mes;
			//window.alert(myXmlHttpRequest.responseXML);
			//获取mes节点
		}
				
	}
	function $(id){return document.getElementById(id);}
	</script>
  </head>
  
  <body >
    <form action="${pageContext.request.contextPath}/servlet/registerServlet" method="post">
    	用户名:<input id="name" name="name" onkeyup="checkName();" type="text" >
    <input type="button" id="check"  name="check" value="验证"> <!-- onclick="checkName();" -->
    <input style="border-width:0;color:red"  type="text" id="nameCheck">
    </form>
  </body>
</html>
