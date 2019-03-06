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



		<table border="1">
			<tr>
				<th>课程名</th>
				<th>退选</th>



			</tr>
			<c:forEach var="exit" items="${sessionScope.sesList}"
				varStatus="loop">
				<tr>
					<td>${exit.cname }</td>


					<td><a
						href="/onlineSC/StudentController/exitsel/${exit.cid }/${exit.sid}">
							退选 </a></td>





				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>