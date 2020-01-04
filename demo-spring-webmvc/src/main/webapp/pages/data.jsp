<%@ page contentType="text/html" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>SpringMvc 传递数据</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
	</head>
	<body>
		<h1>SpringMvc 传递数据</h1>
		<div>
			<form action="addData" method="post">
				姓名：<input type="text" name="name"/> 
				<br/>
				年龄：<input type="text" name="age"/>
				<br/>
				<input type="submit" value="提交"/>
			</form>
		</div>
		
		<div>
			${name }, ${age }
		</div>
	</body>
</html>
