var xmlHttpRequest = "";
function getXMLHttpRequest() {
	try {
		xmlHttpRequest = new XMLHttpRequest();
	} catch (e) {
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlHttpRequest;
}

function $(id) {
	return document.getElementById(id);
}
