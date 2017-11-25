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

	function showProvince(){
		myXmlRequest = getXMLHttpRequest();
		if(myXmlRequest){
			
			var url = "/ajax_userCheck/ProvinceServlet";
			myXmlRequest.onreadystatechange=returnProvince;
			myXmlRequest.open("post",url,true);
			//window.alert($("name"));
			myXmlRequest.send(null);
		}
	}
	function returnProvince(){
		//window.alert("处理函数被调回"+myXmlRequest.responseText);
		//我要取出从registerPro.php页面返回的数据
		if(myXmlRequest.readyState==4){
			//取出值,根据返回信息的格式定.text
			if(myXmlRequest.status==200){
			//var mes = myXmlRequest.responseXML.getElementsByTagName("mes");
			
			//mes[0]->表示取出第一个mes节点
			//mes[0].childNodes[0]->表示第一个mes节点的第一个子节点
			//var mes_val=mes[0].childNodes[0].nodeValue;
			
			var mes = myXmlRequest.responseText;
			
			
			$("province").length=0;
			var myOption = document.createElement("option");
			myOption.innerText="--省份--";
			$("province").appendChild(myOption);
			var mes_arr=eval("("+mes+")");
			//window.alert(mes_arr);
			for(var i=0;i<mes_arr.length;i++){
				var myOption = document.createElement("option");
				var mes_obj=mes_arr[i];
				myOption.value = mes_obj.id;
				myOption.innerText=mes_obj.name;
				$("province").appendChild(myOption);
			}
			}	
		}
		
	}
	
	
	function showCity() {
			myXmlRequest = getXMLHttpRequest();
		if(myXmlRequest){
			var data = "province="+$("province").value;
			//var data = "province="+p.innerText;
			var url = "/ajax_userCheck/CityServlet";
			myXmlRequest.onreadystatechange=returnCity;
			
			myXmlRequest.open("post",url,true);
			myXmlRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			myXmlRequest.send(data);
			}
		}
		
	function returnCity(){
		
		if(myXmlRequest.readyState==4){
		
			if(myXmlRequest.status==200){
			var mes = myXmlRequest.responseText;
			$("city").length=0;
			var myOption = document.createElement("option");
			myOption.innerText="--城市--";
			$("city").appendChild(myOption);
			mes_arr=eval("("+mes+")");
			//window.alert(mes_arr);
			for(var i=0;i<mes_arr.length;i++){
				var myOption = document.createElement("option");
				var city_obj =mes_arr[i];
				myOption.value = city_obj.id;
				myOption.innerText=city_obj.name;
				$("city").appendChild(myOption);
			}
			}	
		}
	}
	
	function showTown() {
			myXmlRequest = getXMLHttpRequest();
		if(myXmlRequest){
			var data = "city="+$("city").value;
			//var data = "province="+p.innerText;
			var url = "/ajax_userCheck/TownServlet";
			myXmlRequest.onreadystatechange=function (){
		
					if(myXmlRequest.readyState==4){
					
						if(myXmlRequest.status==200){
						var mes = myXmlRequest.responseText;
						$("town").length=0;
						var myOption = document.createElement("option");
						myOption.innerText="--乡镇--";
						$("town").appendChild(myOption);
						mes_arr=eval("("+mes+")");
						//window.alert(mes_arr);
						for(var i=0;i<mes_arr.length;i++){
							var myOption = document.createElement("option");
							var town_obj =mes_arr[i];
							myOption.value = town_obj.id;
							myOption.innerText=town_obj.name;
							$("town").appendChild(myOption);
						}
						}	
					}
				};
			
			myXmlRequest.open("post",url,true);
			myXmlRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			myXmlRequest.send(data);
			}
		}
		
	
	
	
	
	function $(id){return document.getElementById(id);}
	</script>
</head>

<body onload="showProvince()">
	<form action="??" method="post">
		<select id="province" onchange="showCity()">
			<option id="-province-" value="--省份--">--省份--</option>
		</select> <select id="city" onchange="showTown()">
			<option id="-city-" value="--城市--">--城市--</option>
		</select> <select id="town" >
			<option id="town" value="--乡镇--">--乡镇--</option>
		</select>
	</form>
</body>
</html>
