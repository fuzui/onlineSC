<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="student" class="net.fuzui.dao.StudentDAO" scope="page" />
<%
	//设置输出信息的格式及字符集
	response.setContentType("text/html;charset=UTF-8");
	response.setHeader("Cache-Control", "no-cache");
	String sid = request.getParameter("SID");
	if(student.queryBySid(sid)){
		out.println("学号已存在");
	}else{
		out.println("学号可用");
	}
	
%>