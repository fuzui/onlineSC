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
			<table border="1">
				<tr>
					<th>所建班级</th>
					<th>上课时间</th>
					<th>上课周</th>
					<th>课程名</th>
					<th>上课教室</th>
					<th>学分</th>
					<th>学时</th>
					<th>总人数</th>

					<th>修改</th>
					<th>删除</th>

				</tr>
				<c:forEach var="courseplan" items="${sessionScope.coursePlanList}"
					varStatus="loop">
					<tr>
						<td>${courseplan.courseclass }</td>
						<td>${courseplan.coursetime }</td>
						<td>${courseplan.courseweek}</td>

						<td>${sessionScope.couList[loop.count-1].cname }</td>

						<td>${courseplan.classroom}</td>
						<td>${courseplan.credits}</td>
						<td>${courseplan.period}</td>
						<td>${courseplan.totalnum}</td>


						<td><a
							href="/onlineSC/CoursePlanController/modicouplan/${courseplan.courseclass}">
								修改 </a></td>
						<td><a
							href="/onlineSC/CoursePlanController/delcouplan/${courseplan.courseclass}/${tid}">
								删除 </a></td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>