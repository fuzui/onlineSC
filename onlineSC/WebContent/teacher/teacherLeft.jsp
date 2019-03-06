<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


你好！ ${sessionScope.tname} &nbsp;老师

<a href="/onlineSC/TeacherController/teacherlogout">注销</a>


<div class="page">
	<section class="demo">
		<ul class="menu">
			<li><a href="/onlineSC/TeacherController/addquery"><strong>添加教学课程</strong></a>
			<br>
			<li><a
				href="/onlineSC/TeacherController/managecou/${sessionScope.tid }"><strong>管理教学课程</strong></a>
			<br>
			<li><a
				href="/onlineSC/TeacherController/sercsc/${sessionScope.tid }"><strong>查看选课名单</strong></a>
			<br>
			<li><a
				href="/onlineSC/TeacherController/queryvita/${sessionScope.tid }"><strong>管理本人信息</strong></a>
		</ul>
	</section>

</div>
