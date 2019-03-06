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
		<form action="../CoursePlanController/queryy" method="get">
			<ul>

				<li>查询条件 <select name="serc">
						<option value="all">全部课程</option>
						<option value="sid">按课程编号查询</option>
						<option value="nam">按课程名查询</option>
						<option value="col">按所属学院查询</option>
						<option value="type">按课程类型查询</option>

				</select>
				<li>条件 <input type="text" name="condition" />
				<li><input type="submit" value="查询" />
			</ul>

		</form>
		 <br /> <br /> <br /> <br>
		<table border="1">
			<tr>
				<th>课程号</th>
				<th>课程名</th>
				<th>课程简介</th>
				<th>类型</th>
				<th>所属学院</th>
				<th>所属专业</th>
				<th>选择</th>

			</tr>
			<c:forEach var="course" items="${sessionScope.courseList}">
				<tr>
					<td>${course.cid }</td>
					<td>${course.cname }</td>
					<td>${course.cintroduction}</td>
					<td>${course.type}</td>
					<td>${course.belongcoll}</td>
					<td>${course.belongpro}</td>


					<td><a
						href="/onlineSC/CoursePlanController/querycouplan/${course.cid}">
							选择 </a></td>


				</tr>

			</c:forEach>

		</table>
</div>
	</div>

</body>



</html>