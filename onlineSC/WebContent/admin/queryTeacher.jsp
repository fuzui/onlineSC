<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网上选课系统</title>

<!-- 标题图标、CSS、js、jQ -->
<link href="../image/favicon.ico" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<script src="../js/fun.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>


</head>

<body>

	<div class="main">
		<div class="main_left" id="frmTitle">
			<jsp:include page="adminLeft.jsp" />
		</div>
		<div class="picBox" onclick="switchSysBar()" id="switchPoint"></div>


		<div class="main1">
		<br>
		<form action="../TeacherController/query" method="get">
			<ul>

				<li>查询条件 <select name="serc">
						<option value="all">全部教师</option>
						<option value="sid">按教师编号查询</option>


				</select>
				<li>条件 <input type="text" name="condition" />
				<li><input type="submit" value="查询" />
			</ul>

		</form>

		<br /> <br /> <br /> <br>





		<table border="1">
			<tr>
				<th>教师工号</th>
				<th>教师姓名</th>
				<th>密码</th>
				<th>性别</th>
				<th>简介</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
			<c:forEach var="teacher" items="${sessionScope.teacherList}">
				<tr>
					<td>${teacher.tid }</td>
					<td>${teacher.tname }</td>
					<td>${teacher.tpassword }</td>
					<td>${teacher.tsex }</td>
					<td>${teacher.introduction}</td>



					<td><a href="../TeacherController/moditystu/${teacher.tid}">
							修改 </a></td>

					<td><a class="deleteCss"
						href="../TeacherController/delete/${teacher.tid}"> 删除 </a></td>
				</tr>

			</c:forEach>
		</table>

		</div>
	</div>

</body>
</html>