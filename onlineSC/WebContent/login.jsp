<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>网上选课系统</title>
		
		<!-- 标题图标、CSS、js、jQ -->
		<link href="image/favicon.ico" rel="shortcut icon">
		<link rel="stylesheet" type="text/css" href="css/main.css">
		<script src="js/fun.js"></script>
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

			
	</head>
	<body>
	<div class="login">
		<c:choose>
			
			
			
			<c:when test="${param.type == 'admin'}">
			
			<div class="login1">
				<form  method="post" class="login" name="login">
				<div class="login_sr">
						管理员登录<br/><br/>
						<input type="text" name="aname" id="aname" class="login_zh" placeholder="管理员账号"></input>
						<br><br>
						<input type="password" name="apassword" id="apassword" class="mm" placeholder="密码"></input><br><br>	
				
						
						
						
						
				</div>
						<br><br>
						<div class="login_submit">
							<input type="submit" onclick="login.action='AdminController/login'" value="登录" />
						</div>
				</form>
			</div>	
				
			</c:when>
			
			
			
			
			
			
			<c:when test="${param.type == 'teacher'}">
			<div class="login1">
				<form action="TeacherController/login" method="post" class="login">
				<div class="login_sr">
						教师登录<br><br>
						<input type="text" name="tid" id="tid" class="login_zh" placeholder="教师工号"></input>
						<br><br>
						<input type="password" name="tpassword" id="tpassword" class="mm" placeholder="密码"></input><br><br>
				</div>
						<br><br>
				<div class="login_submit">
					<input type="submit" value="登录" />
				</div>
				</form>
			</div>
			</c:when>
			
			
			
			
			
			
			
			<c:when test="${param.type == 'student'}">
			<div class="login1">
				<form action="StudentController/login" method="post" class="login">
				<div class="login_sr">
						学生登录<br><br>
						<input type="text" name="sid" id="sid" class="login_zh" placeholder="学号"></input>
						<br><br>
						<input type="password" name="spassword" id="spassword" class="mm" placeholder="密码"></input><br><br>
				</div>
						<br><br>
				<div class="login_submit">
					<input type="submit" value="登录"/>
			    </div>
				</form>
			</div>
			</c:when>
			<c:otherwise>
			
			
			
				<a href = "index.jsp">请选择登录方式</a>
				
				
				
				
			</c:otherwise>
		
		</c:choose>
		
		
		
		</div>
	</body>
</html>