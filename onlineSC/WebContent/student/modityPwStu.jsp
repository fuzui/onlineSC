<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网上选课系统</title>

<!-- 标题图标、CSS、js、jQ -->
<link href="/onlineSC/image/favicon.ico" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="/onlineSC/css/main.css">
<script src="/onlineSC/js/fun.js" type="text/javascript"></script>
<script type="text/javascript" src="/onlineSC/js/jquery-3.3.1.min.js"></script>


</head>

<body>
	<div class="main">
		<div class="main_left" id="frmTitle">
			<jsp:include page="studentLeft.jsp" />
		</div>
		<div class="picBox" onclick="switchSysBar()" id="switchPoint"></div>
		
		
		<div class="main">
		<br><br><br>
		<form
			action="../StudentController/moditypasswordstu/${sessionScope.sid }"
			method="get">


			<input type="password" name="spassword" /> <input type="submit"
				value="确定修改" />

		</form>
		</div>

	</div>
</body>
</html>