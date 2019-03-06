package net.fuzui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import net.fuzui.beans.SC;
import net.fuzui.beans.StuExitSelect;
import net.fuzui.beans.StuSelectResult;
import net.fuzui.beans.Student;

public class SCDAO {
	/*
	 * 根据学号学生查询自己已选的课
	 */
	public ArrayList<SC>getAllSC(String sid) {
		SC sc = null;
		ArrayList<SC>scList = new ArrayList<SC>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from SC where sid = '"+sid+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				sc = new SC();
				sc.setId(rs.getInt("id"));
				sc.setCid(rs.getString("cid"));
				sc.setSid(rs.getString("sid"));
				scList.add(sc);
				
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return scList;
	}
	
	/*
	 * 根据课程编号查询选课表
	 */
	
	public ArrayList<SC>getByCidSC(String cid) {
		SC sc = null;
		ArrayList<SC>scList = new ArrayList<SC>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from SC where cid = '"+cid+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				sc = new SC();
				sc.setId(rs.getInt("id"));
				sc.setCid(rs.getString("cid"));
				sc.setSid(rs.getString("sid"));
				scList.add(sc);
				
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return scList;
	}
	
	
	
	
	public ArrayList<StuSelectResult>getBysidSC(String sid) {
		
		StuSelectResult ssr = new StuSelectResult();
		ArrayList<StuSelectResult> ssrList = new ArrayList<StuSelectResult>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			
			/*
			
		
			select course.cname,courseplan.courseclass,courseplan.coursetime,courseplan.courseweek,courseplan.classroom,courseplan.credits,courseplan.period,teacher.tname from sc,courseplan,course,teacher where sc.cid =courseplan.cid and sc.cid = course.cid  and courseplan.tid= teacher.tid and sc.sid="201507024125";
			
			*/
			
			String sql = "select course.cname,courseplan.courseclass,courseplan.coursetime,courseplan.courseweek,courseplan.classroom,courseplan.credits,courseplan.period,teacher.tname from sc,courseplan,course,teacher where sc.cid =courseplan.cid and sc.cid = course.cid  and courseplan.tid= teacher.tid and sc.sid='"+sid+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				ssr = new StuSelectResult();
				ssr.setCname(rs.getString("cname"));
				ssr.setClassr(rs.getString("courseclass"));
				ssr.setCoursetime(rs.getString("coursetime"));
				ssr.setCourseweek(rs.getString("courseweek"));
				ssr.setClassroom(rs.getString("classroom"));
				ssr.setCredits(rs.getString("credits"));
				ssr.setPeriod(rs.getString("period"));
				ssr.setTname(rs.getString("tname"));
				ssrList.add(ssr);
				
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return ssrList;
	}
	
	
	
	
	/*
	 * 学生退选
	 */
public ArrayList<StuExitSelect>getExitBysid(String sid) {
		
		StuExitSelect ses = new StuExitSelect();
		ArrayList<StuExitSelect> exitList = new ArrayList<StuExitSelect>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			
		
			
			String sql = "select cname,sc.cid,sid from course,sc where sc.cid=course.cid and sid='"+sid+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				ses = new StuExitSelect();
				ses.setCname(rs.getString("cname"));
				ses.setCid(rs.getString("cid"));
				ses.setSid(rs.getString("sid"));
				exitList.add(ses);
				
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return exitList;
	}




public boolean deleteSC(String cid) {
	boolean result = false;
	Connection conn = null;
	int n = 0;
	
	try {
		conn = DBGet.getConnection();
				
		String sql="delete from sc where cid= ?";
		PreparedStatement ps =conn.prepareStatement(sql);
		
		ps.setString(1, cid);
		n = ps.executeUpdate();
	}catch (SQLException el) {
		System.out.println(el+"dao");
	}finally {
		DBGet.closeConnection(conn);
	}
	if(n>0) {
		result = true;
	}
	return result;
}






/*
 * 教师查看名单
 */
public ArrayList<StuExitSelect>getLookByTid(String tid) {
	
	StuExitSelect ses = new StuExitSelect();
	ArrayList<StuExitSelect> exitList = new ArrayList<StuExitSelect>();
	
	Connection conn = null;
	ResultSet rs = null;
	Statement stmt = null;
	try{
		conn = DBGet.getConnection();
		stmt = conn.createStatement();
		
	
		
		String sql = "select cname,courseplan.cid,tid from course,courseplan where courseplan.cid=course.cid and courseplan.tid='"+tid+"'";
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			ses = new StuExitSelect();
			ses.setCname(rs.getString("cname"));
			ses.setCid(rs.getString("cid"));
			ses.setSid(rs.getString("tid"));  
			exitList.add(ses);
			
		}
	}catch (SQLException e1) {
		System.out.println(e1+"dao");
	}
	finally {
		DBGet.closeConnection(conn);
	}
	return exitList;
}






/*
 * 根据课程编号查询
 */
public ArrayList<Student>getByStuSid(String cid) {
	Student student = null;
	ArrayList<Student>studentList = new ArrayList<Student>();
	
	Connection conn = null;
	ResultSet rs = null;
	Statement stmt = null;
	try{
		conn = DBGet.getConnection();
		stmt = conn.createStatement();
		String sql = "SELECT * from student,sc where student.sid=sc.sid and cid = '"+cid+"'";
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			student = new Student();
			student.setSid(rs.getString("sid"));
			student.setSname(rs.getString("sname"));
			student.setSidcard(rs.getString("sidcard"));
			student.setSsex(rs.getString("ssex"));
			student.setSpassword(rs.getString("spassword"));
			student.setSage(rs.getString("sage"));
			student.setClassr(rs.getString("classr"));
			student.setProfession(rs.getString("profession"));
			student.setCollege(rs.getString("college"));
			
			studentList.add(student);
			
		}
	}catch (SQLException e1) {
		System.out.println(e1+"dao");
	}
	finally {
		DBGet.closeConnection(conn);
	}
	return studentList;
}




	
}
