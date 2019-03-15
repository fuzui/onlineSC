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
			<jsp:include page="teacherLeft.jsp" />
		</div>
		<div class="picBox" onclick="switchSysBar()" id="switchPoint"></div>


		<div class="main1">
		<br> 开班名 ${cname}



		<table border="1">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>班级</th>
				<th>专业</th>
				<th>学院</th>

			</tr>
			<c:forEach var="student" items="${sessionScope.lookList}">
				<tr>
					<td>${student.sid}</td>
					<td>${student.sname }</td>
					<td>${student.ssex}</td>
					<td>${student.classr}</td>
					<td>${student.profession}</td>
					<td>${student.college}</td>


				</tr>

			</c:forEach>
		</table>
		</div>
	</div>
</body>


</html>