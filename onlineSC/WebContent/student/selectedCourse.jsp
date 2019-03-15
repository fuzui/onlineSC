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
			<br>提示：没有教师安排的课程无法查询<br>

			<table border="1">
				<tr>
					<th>课程名</th>
					<th>班级名称</th>
					<th>上课时间</th>
					<th>上课周</th>
					<th>上课教室</th>
					<th>学分</th>
					<th>学时</th>
					<th>代课老师</th>



				</tr>
				<c:forEach var="ssr" items="${sessionScope.ssrList}"
					varStatus="loop">
					<tr>
						<td>${ssr.cname }</td>
						<td>${ssr.classr }</td>
						<td>${ssr.coursetime }</td>
						<td>${ssr.courseweek}</td>
						<td>${ssr.classroom}</td>
						<td>${ssr.credits}</td>
						<td>${ssr.period}</td>
						<td>${ssr.tname}</td>




					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>