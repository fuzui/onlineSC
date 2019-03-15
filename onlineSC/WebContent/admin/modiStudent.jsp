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
				<h2>修改学生</h2>
				<c:forEach var="student" items="${sessionScope.studentList}">
							
					<form action="../moditystud/${student.sid}" method="get">
						<ul>
					    
								<li>姓名：
								<input type="text" name="sname" value="${student.sname }"></input>
								<li>身份证号：
								<input type="text" name="sidcard" value="${student.sidcard }"></input>
								
								<br/>
								性别
								<c:choose>
									<c:when test="${student.ssex == '男'}">
								
										男<input type="radio" value="男" name="ssex" checked/>
										女<input type="radio" value="女" name="ssex" /><br/>
									</c:when>
								
									<c:otherwise>
										男<input type="radio" value="男" name="ssex" />
										女<input type="radio" value="女" name="ssex" checked/><br/>
									</c:otherwise>
								</c:choose>
								
								
								<br/>
								<li>
								密码<input type="text" name="spassword" value="${student.spassword }"></input>
								<li>年龄：
								<input type="text" name="sage" value="${student.sage }"></input>
								<li>班级：
								<input type="text" name="classr" value="${student.classr }"></input>
								<li>专业：
								<input type="text" name="profession" value="${student.profession }"></input>
								<li>学院：
								<input type="text" name="college" value="${student.college }"></input>
								<li>
			
			
								</ul>
    
    							<br/>
    					<input type="submit" value="修改"/>
   					</form>
				</c:forEach>	
			</div>
		</div>
	</body>
</html>