<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="teacher" class="net.fuzui.dao.TeacherDAO" scope="page" />
<%
	//设置输出信息的格式及字符集
	response.setContentType("text/html;charset=UTF-8");
	response.setHeader("Cache-Control", "no-cache");
	String tid = request.getParameter("TID");
	if(teacher.queryByTid(tid)){
		out.println("教师工号已存在");
	}else{
		out.println("教师工号可用");
	}
	
%>