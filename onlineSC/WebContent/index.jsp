<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网上选课系统</title>

<!-- 标题图标、CSS、js、jQ -->
<link href="image/favicon.ico" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/fun.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>


</head>
<body>

	<marquee behavior="alternate">
		<font face="华文行楷" size="+22">网上选课系统</font>
	</marquee>
	<div class="index">
		<form action="login.jsp" class="index_admin">
			<input type="hidden" name="type" value="admin"> <input
				type="submit" value="管理员登录" />
		</form>

		<form action="login.jsp" class="index_teacher">
			<input type="hidden" name="type" value="teacher"> <input
				type="submit" value="教师登录" />
		</form>

		<form action="login.jsp" class="index_student">
			<input type="hidden" name="type" value="student"> <input
				type="submit" value="学生登录" />
		</form>
	</div>

</body>
</html>