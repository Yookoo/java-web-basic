function sendMessage(){
	myXmlHttpRequest = getXMLHttpRequest();
	if(myXmlHttpRequest){
		
		var url = contextPath+"/chat.do?flag=goChat";
		window.alert(url);
		
		data = "&gId="+gid+"&message="+$('chatext').value;
		window.alert(data);
		//回调
		myXmlHttpRequest.onreadystatechange=function(){
			if(myXmlHttpRequest.readyState==4){
				//取出值,根据返回信息的格式定.text
				if(myXmlHttpRequest.status==200){
				
				var mes = myXmlHttpRequest.responseText;
				
				var mes_obj=eval("("+mes+")");
				
				$("chatarea").value +=sName+"　"+mes_obj.stime+"\n"+mes_obj.con+"\n";
				
				}	
			}
			
			
		};
		myXmlHttpRequest.open("post",url,true);
		myXmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		myXmlHttpRequest.send(data);
	}
}

window.setInterval("getMessage()",3000);

function getMessage() {
	myXmlHttpRequest = getXMLHttpRequest();
	if(myXmlHttpRequest){
		
		var url = contextPath+"/chat.do?flag=getMessage";
		//window.alert(url);
		
		data = "&sid="+gid;
		//window.alert(data);
		//回调
		myXmlHttpRequest.onreadystatechange=function(){
			if(myXmlHttpRequest.readyState==4){
				//取出值,根据返回信息的格式定.text
				if(myXmlHttpRequest.status==200){
				
				var mes = myXmlHttpRequest.responseText;
				
				var mes_arr=eval("("+mes+")");
				for ( var i = 0; i < mes_arr.length; i++) {
					$("chatarea").value += mes_arr[i].sName+"　"+mes_arr[i].stime+"\n"+mes_arr[i].con+"\n";
				}
				
				
				}	
			}
			
			
		};
		myXmlHttpRequest.open("post",url,true);
		myXmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		myXmlHttpRequest.send(data);
	}
}