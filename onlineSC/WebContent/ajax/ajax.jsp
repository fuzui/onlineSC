<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="student" class="net.fuzui.dao.CourseDAO" scope="page" />
<%
	//设置输出信息的格式及字符集
	response.setContentType("text/html;charset=UTF-8");
	response.setHeader("Cache-Control", "no-cache");
	String cid = request.getParameter("CID");
	if(student.queryByCid(cid)){
		out.println("课程编号已存在");
	}else{
		out.println("课程编号可用");
	}
	
%>