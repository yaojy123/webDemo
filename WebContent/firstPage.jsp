<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%if(session.getAttribute("userName") == null){%>
	<script type="text/javascript">
	alert("还没有登陆，请先登陆")
	top.location.href="login.html";
	
	</script>
<%} %>
<h2>首页，登陆成功</h2>
<img alt="" src="img/-57cba83ffc52471b.jpg">

</body>
</html>