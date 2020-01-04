<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>demo-springsession</title>
	</head>
	<body>
		<h2>Hello World!</h2>
		<%=request.getSession().getId() %>
		<%
			request.getSession().setAttribute("username", "wangke");
		%>
	</body>
</html>
