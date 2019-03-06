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
			$("#cid").change(function(){
				$.get("/onlineSC/ajax/ajax.jsp?CID="+$("#cid").val(),function(data,status){
					$("#countt").html(data);
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
		  		<h2>添加课程</h2>
				<form action="/onlineSC/CourseController/addCourse" method="post">
					<ul>
						<li>课程编号：
						<input type="text" name="cid" id="cid"></input>
						<span id="countt" style="color:#ff0000;"></span><br/><br/>
						<li>课程名称：
						<input type="text" name="cname"></input>
						<li>课程简介：
						<textarea name="cintroduction" cols="20" rows="6"></textarea>
						
						<li>
						<select name="type">
							<option value="必修">必修</option>
							<option value="选修">必修</option>
						</select>
						<li>
						<select name="belongcoll">
							<option value="计算机学院">计算机学院</option>
							<option value="建筑学院">建筑学院</option>
							<option value="外国语学院">外国语学院</option>
							<option value="人文学院">人文学院</option>
						</select>
						
						<li>
						<select name="belongpro">
							<option value="网络工程">网络工程</option>
							<option value="软件工程">软件工程</option>
							<option value="英语">英语</option>
							<option value="日语">日语</option>
							<option value="土木工程">土木工程</option>
							<option value="测绘">测绘</option>
							<option value="历史">历史</option>
						</select>
						<input type="submit" value="添加" />	
					</ul>		
				</form>
			</div>	
		</div>		
	</body>
</html>