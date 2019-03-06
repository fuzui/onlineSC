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


		<div class="main1">
			<table border="1">

				<tr>
					<td>/</td>
					<td>信息</td>
					<td>介绍</td>
				</tr>

				<tr>
					<td>学号</td>
					<td>${sid }</td>
					<td>学生信息唯一标示</td>
				</tr>

				<tr>
					<td>姓名</td>
					<td>${sname }</td>
					<td>不可修改</td>
				</tr>

				<tr>
					<td>身份证</td>
					<td>${requestScope.sidcard }</td>
					<td>不可修改</td>
				</tr>

				<tr>
					<td>性别</td>
					<td>${requestScope.ssex }</td>
					<td>不可修改</td>
				</tr>

				<tr>
					<td>密码</td>
					<td>${requestScope.spassword }</td>
					<td><a href="../moditypwstu/${sessionScope.sid }">修改 </a></td>
				</tr>

				<tr>
					<td>年龄</td>
					<td>${requestScope.sage }</td>
					<td>不可修改</td>
				</tr>


				<tr>
					<td>班级</td>
					<td>${requestScope.classr }</td>
					<td>不可修改</td>
				</tr>


				<tr>
					<td>专业</td>
					<td>${requestScope.profession }</td>
					<td>不可修改</td>
				</tr>
				<tr>
					<td>学院</td>
					<td>${requestScope.college }</td>
					<td>不可修改</td>
				</tr>


			</table>
		</div>
	</div>
</body>
</html>