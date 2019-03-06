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
			$("#tid").change(function(){
				$.get("/onlineSC/ajax/ajaxtid.jsp?TID="+$("#tid").val(),function(data,status){
					$("#counttid").html(data);
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
				<h2>添加教师</h2>
				<form action="/onlineSC/TeacherController/addTeacher" method="post">
					<ul>
						<li>教师编号：
						<input type="text" name="tid" id="tid"></input>
						<span id="counttid" style="color:#ff0000;"></span>
						<li>姓名：
						<input type="text" name="tname"></input>
						<li>密&nbsp;&nbsp;码：
						<input type="password" name="tpassword"></input><br/><br/>
						<li>性别：
							男
						<input type="radio" value="男" name="tsex">
							女
						<input type="radio" value="女" name="tsex"><br><!--radio性别选择 -->
						
						<li>个人简介
						<textarea name="introduction" cols="20" rows="6"></textarea>
						<li>
						<input type="submit" value="添加" />
					</ul>			
				</form>
			</div>
		</div>	
	</body>
</html>