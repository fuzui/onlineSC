<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="couplan" class="net.fuzui.dao.CoursePlanDAO" scope="page" />
<%
	//设置输出信息的格式及字符集
	response.setContentType("text/html;charset=UTF-8");
	response.setHeader("Cache-Control", "no-cache");
	String coursetime = request.getParameter("coursetime");
	String courseweek = request.getParameter("courseweek");
	String classroom = request.getParameter("classroom");
	if(couplan.queryBy(coursetime, courseweek, classroom)){
		out.println("该时间点的教室已有课，请重新选择时间或教室");
	}else{
		out.println("该时间点教室可安排");
	}
	
%>