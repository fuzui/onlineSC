<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  				<jsp:include page="adminLeft.jsp" />
  			</div>
  			<div class="picBox" onclick="switchSysBar()" id="switchPoint" ></div>

			<div class="main1">
				<h2>修改教师</h2>
				<c:forEach var="teacher" items="${sessionScope.teacherList}">
					
					<form action="../moditystud/${teacher.tid}" method="get">>
						<ul>							
							<li>姓名：
							<input type="text" name="tname" value="${teacher.tname }"></input>
							<li>密&nbsp;&nbsp;码：
							<input type="password" name="tpassword" value="${teacher.tpassword }"></input><br/><br/>
							<li>性别
							<c:choose>
								<c:when test="${teacher.tsex == '男'}">
							
									男<input type="radio" value="男" name="tsex" checked/>
									女<input type="radio" value="女" name="tsex" /><br/>
								</c:when>
							
								<c:otherwise>
									男<input type="radio" value="男" name="tsex" />
									女<input type="radio" value="女" name="tsex" checked/><br/>
								</c:otherwise>
							</c:choose>
							
							<li>个人简介
							<textarea name="introduction" cols="20" rows="6">${teacher.introduction }</textarea>
							<li>
							<input type="submit" value="修改"/>							
						</ul>					    
				    	<br/>				   
					</form>
				</c:forEach>	
			</div>
		</div>
	</body>
</html>