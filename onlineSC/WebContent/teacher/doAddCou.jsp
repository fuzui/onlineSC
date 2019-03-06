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
<script type="text/javascript">
		$(document).ready(function(){
			$("#cid").change(function(){
				$.get("/onlineSC/ajax/ajaxCouPlan.jsp?coursetime="+$("coursetime").val()+"&courseweek="+$("courseweek").val()+"&classroom="+$("classroom").val(),function(data,status){
					$("#couplan").html(data);
				})
				
			})
			
			
		})
				
		
	
	</script>

</head>




<body>
	<div class="main">
		<div class="main_left" id="frmTitle">
			<jsp:include page="teacherLeft.jsp" />
		</div>
		<div class="picBox" onclick="switchSysBar()" id="switchPoint"></div>


	
		<div class="main1">
		<form action="/onlineSC/CoursePlanController/doaddcouplan"
			method="get">
			<br /> 新建班级名称 <input type="text" name="courseclass" /> <br>

			上课时间
			<p>
				<input type="checkbox" name="coursetime" id="coursetime" value="12" /> 第一二节
			</p>
			<p>
				<input type="checkbox" name="coursetime" value="34" /> 第三四节
			</p>
			<p>
				<input type="checkbox" name="coursetime" value="56" /> 第五六节
			</p>
			<p>
				<input type="checkbox" name="coursetime" value="78" /> 第七八节
			</p>

			<br> 上课周
			<p>
				<input type="checkbox" name="courseweek" id="courseweek" value="1" /> 星期一
			</p>
			<p>
				<input type="checkbox" name="courseweek" value="2" /> 星期二
			</p>
			<p>
				<input type="checkbox" name="courseweek" value="3" /> 星期三
			</p>
			<p>
				<input type="checkbox" name="courseweek" value="4" /> 星期四
			</p>
			<p>
				<input type="checkbox" name="courseweek" value="5" /> 星期五
			</p>
			<p>
				<input type="checkbox" name="courseweek" value="6" /> 星期六
			</p>
			<p>
				<input type="checkbox" name="courseweek" value="7" /> 星期日
			</p>
			

			<br> 课程编号 <input type="text" name="cid" value="${cid }" /> <br>
			教师编号 <input type="text" name="tid" value="${sessionScope.tid }" /> <br>
			上课教室 <input type="text" name="classroom" id="classroom" /> 
			<span id="couplan" style="color:#ff0000;"></span>
			<br> 
			学分 <input type="text" name="credits" /> <br> 学时 <input type="text"
				name="period" /> <br> 总人数 <input type="text" name="totalnum" />
			<br> <input type="submit" value="添加" />






		</form>
		</div>
		<br /> <br /> <br />
	</div>
</body>

</html>