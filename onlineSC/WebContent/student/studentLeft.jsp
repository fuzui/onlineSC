<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



你好！

${sessionScope.sname} 
<a href="/onlineSC/StudentController/studentlogout">注销</a>


<div class="page">
	<section class="demo">
		<ul class="menu">

			<li><a href="/onlineSC/StudentController/selqueryy"><strong>选课</strong></a>
			<br>
			<li><a href="/onlineSC/StudentController/selcouresult/${sessionScope.sid }"><strong>查看选课结果</strong></a>
			<br>

			<li><a href="/onlineSC/StudentController/exitchoose/${sessionScope.sid }"><strong>退选</strong></a>
			<br>
			<li><a href="/onlineSC/StudentController/queryvitastu/${sessionScope.sid }"><strong>管理个人信息</strong></a>

			<br>

	</ul>
	</section>

</div>