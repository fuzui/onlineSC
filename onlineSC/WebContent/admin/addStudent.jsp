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
		<script type="text/javascript">
		$(document).ready(function(){
			$("#sid").change(function(){
				$.get("/onlineSC/ajax/ajaxsid.jsp?SID="+$("#sid").val(),function(data,status){
					$("#countsid").html(data);
				})			
			})		
		})
		</script>
	</head>
	
	<body>
	<div class="main">
  		<div class="main_left" id="frmTitle"> 
  			<jsp:include page="adminLeft.jsp" />
  		</div>
 		 <div class="picBox" onclick="switchSysBar()" id="switchPoint" ></div>

			<div class="main1">
				<h2>添加学生</h2>
				<form action="/onlineSC/StudentController/addStudent" method="post">
					<ul>
						<li>学号：
						<input type="text" name="sid" id="sid"></input>
						<span id="countsid" style="color:#ff0000;"></span>
						<li>姓名：
						<input type="text" name="sname"></input>
						<li>身份证号：
						<input type="text" name="sidcard"></input>
						<li>性别：
							男
						<input type="radio" value="男" name="ssex">
							女
						<input type="radio" value="女" name="ssex"><br><!--radio性别选择 -->
						
						<li>密&nbsp;&nbsp;码：
						<input type="password" name="spassword"></input><br/><br/>
						
						<li>年龄：
						<input type="text" name="sage"></input>
						<li>班级：
						<input type="text" name="classr"></input>
						<li>专业：
						<input type="text" name="profession"></input>
						<li>学院：
						<input type="text" name="college"></input>
						<li>
						<input type="submit" value="添加" />	
					</ul>		
				</form>
			</div>
		</div>	
	</body>
</html>