<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




你好！ ${sessionScope.aname}


<a href="/onlineSC/AdminController/adminlogout">退出登录</a>

<div class="page">
	<section class="demo">
		<ul class="menu">

			<li><a href="/onlineSC/StudentController/managestu"><strong>学生管理</strong></a>
			<br/>
			<li><a href="/onlineSC/StudentController/managetea"><strong>教师管理</strong></a>
			<br/>
			
			<li><a href="/onlineSC/StudentController/managecou"><strong>课程管理</strong></a>
			<br/>
			<li><a href="/onlineSC/StudentController/addstu"><strong>添加学生</strong></a>
			<br/>
			<li><a href="/onlineSC/StudentController/addtea"><strong>添加教师</strong></a>
			<br/>
			<li><a href="/onlineSC/StudentController/addcou"><strong>添加课程</strong></a>
		</ul>
	</section>
</div>

