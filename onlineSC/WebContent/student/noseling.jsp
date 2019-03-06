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
			<p>课程名</p>
			${cname} <br> 该课程暂无教师代理，是否选课等待？

			<form action="../seling" method="get">


				<input type="hidden" name="cid" value="${cid }" /> <input
					type="hidden" name="sid" value="${sessionScope.sid }" /> <input
					type="submit" value="确定选课" />

			</form>
			<form action="../backseling/${cid }" method="get">


				<input type="submit" value="取消选课" />

			</form>
		</div>
	</div>
</body>
</html>