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
			<jsp:include page="teacherLeft.jsp" />
		</div>
		<div class="picBox" onclick="switchSysBar()" id="switchPoint"></div>





		<div class="main1">
			<h2>修改课程</h2>
			<c:forEach var="cplan" items="${sessionScope.cPlanList}">

				<form action="../moditycouplan/${cplan.tid }" method="get">


					新建班级名称 <input type="text" name="courseclass"
						value="${cplan.courseclass}" /> <br> 上课时间
					${cplan.coursetime}节 选择
					<p>
						<input type="checkbox" name="coursetime" value="12" /> 第一二节
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

					<br> 上课周 ${cplan.courseweek}周 选择
					<p>
						<input type="checkbox" name="courseweek" value="1" />星期一
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


					<br> 课程编号：不可以修改 
					<input type="text" name="cid" value="${cplan.cid }" /> <br>
					 教师编号:不可修改 <input type="text" name="tid" value="${sessionScope.tid }" /> <br> 
					 上课教室 <input type="text" name="classroom" value="${cplan.classroom }" /> <br>
					学分 <input type="text" name="credits" value="${cplan.credits }" /> <br> 
					学时 <input type="text" name="period" value="${cplan.period }" /> <br> 
					总人数 <input type="text" name="totalnum" value="${cplan.totalnum }" /> <br> 
					<input type="submit" value="修改" /> <br />

				</form>
			</c:forEach>
		</div>
	</div>
</body>
</html>