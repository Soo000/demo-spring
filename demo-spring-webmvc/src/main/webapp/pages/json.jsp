<%@ page contentType="text/html" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Demo SpringMvc Json</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.9.1.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#btnSubmit").click(function() {
					var name = $("#name").val();
					var age = $("#age").val();

					var jsnUser = {"name": name, "age": age};
					
					$.ajax({
						url: 'addJson',
						type: 'post',
						data: {name:name, age:age},
						success: function(a) {
							alert(a);
						},
						failed: function(b) {
							alert(2);
						}
					});
				});
			});
		</script>
	</head>
	<body>
		姓名：<input type="text" id="name" name="name"/>
		<br />
		年龄：<input type="text" id="age" name="age"/>
		<br />
		<input type="button" id="btnSubmit" value="提交"/>
	</body>
</html>
