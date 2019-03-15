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
		<form action="../StudentController/query" method="get">
			<ul>

				<li>查询条件 <select name="serc">
						<option value="all">全部学生</option>
						<option value="sid">按学号查询</option>
						<option value="col">按学院查询</option>
						<option value="pro">按专业查询</option>
						<option value="cla">按班级查询</option>
				</select>
				<li>条件 <input type="text" name="condition" />
				<li><input type="submit" value="查询" />
			</ul>

		</form>

		<br /> <br /> <br /> <br>





		<table border="1">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>身份证</th>
				<th>性别</th>
				<th>密码</th>
				<th>年龄</th>
				<th>班级</th>
				<th>专业</th>
				<th>学院</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
			<c:forEach var="student" items="${sessionScope.studentList}">
				<tr>
					<td>${student.sid}</td>
					<td>${student.sname }</td>
					<td>${student.sidcard}</td>
					<td>${student.ssex}</td>
					<td>${student.spassword}</td>
					<td>${student.sage}</td>
					<td>${student.classr}</td>
					<td>${student.profession}</td>
					<td>${student.college}</td>

					<td><a href="../StudentController/moditystu/${student.sid}">
							修改 </a></td>

					<td><a class="deleteCss"
						href="../StudentController/delete/${student.sid}"> 删除 </a></td>
				</tr>

			</c:forEach>
		</table>
		</div>
	</div>

</body>
</html>