<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	        + request.getServerName() + ":" + request.getServerPort()
	        + path + "/";
	%>
	<!--request是jsp里面的内置对象,下面这一段是url，标准写法-->
	<input type="button" id="doGetTest" value="get"/>
	<input type="button" id="doPostTest" value="post"/>
	<!--result Myservlet返回给前端的数据，放在p里面-->
	<p id="result">	</p>
	<script type="text/javascript">
		function getXhr(){
	        var xhr= null;
	        //实现 ajax之前必须要创建一个 XMLHttpRequest对象，如果不支持创建该对象的浏览器，则需要创建 ActiveXObject
	        if(window .XMLHttpRequest){
	             xhr =new XMLHttpRequest();// IE7+, Firefox, Chrome, Opera, Safari
	        }else{
	             xhr =new ActiveXObject("Microsoft.XMLHttp" );// 老版本的 Internet Explorer （IE5 和 IE6）使用 ActiveX 对象：
	        }
	        return xhr;
	     }
	
		document.getElementById("doGetTest").addEventListener("click",
			function doGet(){
			 var xhr= getXhr();
	         var url ="<%=basePath%>MyServlet";
	         xhr.open("GET",url,true);
	         xhr.send(null);
	         xhr.onreadystatechange=function (){
	        	 if(xhr.readyState== 4 && xhr.status ==200){
	        		 document.getElementById("result").innerHTML = xhr.responseText;
				}

	         }
		});
		 document.getElementById("doPostTest").addEventListener("click",
			function doPost(){
			 var xhr= getXhr();
			 var parm = "act=" + document.getElementById("doPostTest").value;
	         var url ="<%=basePath%>MyServlet";
	         xhr.open("post",url,true);
	         xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	         xhr.send(parm);
	         xhr.onreadystatechange=function (){
	        	 if(xhr.readyState== 4 && xhr.status ==200){
	        		 document.getElementById("result").innerHTML = xhr.responseText;
				}

	         }
		});
	</script>
</body>
</html>