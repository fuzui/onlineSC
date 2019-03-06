package net.fuzui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import net.fuzui.beans.Course;
import net.fuzui.beans.Teacher;


public class CourseDAO {
	
	/*
	 * ��ӿγ�
	 */
	public boolean addCourse(Course course) {
		boolean result = false;
		Connection conn = null;
		int n = 0;
		try {
			conn = DBGet.getConnection();
			String sql="insert into course values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, course.getCid());
			ps.setString(2, course.getCname());
			ps.setString(3, course.getCintroduction());
			ps.setString(4, course.getType());
			ps.setString(5, course.getBelongcoll());
			ps.setString(6, course.getBelongpro());
			
			n=ps.executeUpdate();
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
	 * ��ѯȫ���γ�
	 */
	public ArrayList<Course>getAllCourse() {
		Course course = null;
		ArrayList<Course>courseList = new ArrayList<Course>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from course";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				course = new Course();
				course.setCid(rs.getString("cid"));
				course.setCname(rs.getString("cname"));
				course.setCintroduction(rs.getString("cintroduction"));
				course.setType(rs.getString("type"));
				course.setBelongcoll(rs.getString("belongcoll"));
				course.setBelongpro(rs.getString("belongpro"));
				courseList.add(course);
				
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return courseList;
	}
	
	/*
	 * ���ݿγ̱�Ų�ѯ
	 */
	public ArrayList<Course>getCourseCid(String cid) {
		Course course = null;
		ArrayList<Course>courseList = new ArrayList<Course>();
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from course where cid = '"+cid+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				course = new Course();
				course.setCid(rs.getString("cid"));
				course.setCname(rs.getString("cname"));
				course.setCintroduction(rs.getString("cintroduction"));
				course.setType(rs.getString("type"));
				course.setBelongcoll(rs.getString("belongcoll"));
				course.setBelongpro(rs.getString("belongpro"));
				courseList.add(course);
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return courseList;
	}
	
	/*
	 * ���ݿγ�����ѯ
	 */
	public ArrayList<Course>getCourseName(String cname) {
		Course course = null;
		ArrayList<Course>courseList = new ArrayList<Course>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from course where cname = '"+cname+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				course = new Course();
				course.setCid(rs.getString("cid"));
				course.setCname(rs.getString("cname"));
				course.setCintroduction(rs.getString("cintroduction"));
				course.setType(rs.getString("type"));
				course.setBelongcoll(rs.getString("belongcoll"));
				course.setBelongpro(rs.getString("belongpro"));
				courseList.add(course);
				
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return courseList;
	}
	
	/*
	 * ���ݿγ����Ͳ�ѯ
	 */
	public ArrayList<Course>getCourseType(String type) {
		Course course = null;
		ArrayList<Course>courseList = new ArrayList<Course>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from course where type = '"+type+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				course = new Course();
				course.setCid(rs.getString("cid"));
				course.setCname(rs.getString("cname"));
				course.setCintroduction(rs.getString("cintroduction"));
				course.setType(rs.getString("type"));
				course.setBelongcoll(rs.getString("belongcoll"));
				course.setBelongpro(rs.getString("belongpro"));
				courseList.add(course);
				
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return courseList;
	}
	
	/*
	 * ��������ѧԺ��ѯ
	 */
	public ArrayList<Course>getCourseCol(String college) {
		Course course = null;
		ArrayList<Course>courseList = new ArrayList<Course>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from course where belongcoll = '"+college+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				course = new Course();
				course.setCid(rs.getString("cid"));
				course.setCname(rs.getString("cname"));
				course.setCintroduction(rs.getString("cintroduction"));
				course.setType(rs.getString("type"));
				course.setBelongcoll(rs.getString("belongcoll"));
				course.setBelongpro(rs.getString("belongpro"));
				courseList.add(course);
				
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return courseList;
	}
	
	/*
	 * �޸Ŀγ���Ϣ
	 */
	public boolean modify(Course course) {
		boolean result = false;
		int n= 0;
		Connection conn =null;
		String sql = null;
		try {
			conn = DBGet.getConnection();
			sql="update course set cname=?,cintroduction=?,type=?,belongcoll=?,belongpro=? where cid =?";
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ps.setString(1, course.getCname());
			ps.setString(2, course.getCintroduction());
			ps.setString(3, course.getType());
			ps.setString(4, course.getBelongcoll());
			ps.setString(5, course.getBelongpro());
			ps.setString(6, course.getCid());
			n = ps.executeUpdate();
		}catch (SQLException e1) {
			System.out.println(e1+"dao"+sql);
		}finally {
			DBGet.closeConnection(conn);
		}
		if (n>0) 
			result = true;
		return result;
	}
		
	/*
	 * ɾ���γ���Ϣ
	 */
	public boolean deleteCourse(String cid) {
		boolean result = false;
		Connection conn = null;
		int n = 0;
		Statement stmt = null;
		try {
			conn = DBGet.getConnection();
			stmt = conn.createStatement();		
			String sql="delete from course where cid="+cid;
			n=stmt.executeUpdate(sql);
			
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
	 * ���������ݿγ̰��ű��н�ʦ��Ų�ѯ���γ̱�ţ�
	 */
	/*
	 * ���ݿγ̱�Ų�ѯ
	 */
	public ArrayList<Course>getCoursetid(String tid) {
		Course course = null;
		ArrayList<Course>courseList = new ArrayList<Course>();
		Connection conn = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		Statement stmt = null;
		String cid = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			
			
			String sql2 = "select cid from courseplan where tid = '"+tid+"'";
			rs2=stmt.executeQuery(sql2);
			if(rs2!=null) {
			
			if(rs2.next()) {
				cid = rs2.getString("cid");
				System.out.println(cid);
			}
			
			
			String sql = "SELECT * from course where cid = '"+cid+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				course = new Course();
				course.setCid(rs.getString("cid"));
				course.setCname(rs.getString("cname"));
				course.setCintroduction(rs.getString("cintroduction"));
				course.setType(rs.getString("type"));
				course.setBelongcoll(rs.getString("belongcoll"));
				course.setBelongpro(rs.getString("belongpro"));
				courseList.add(course);
			}
			
			
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return courseList;
	}
	
	
	
	/*
	 * ��ѯ�ÿγ��Ƿ�����ʦ����
	 */
	public boolean selectedCourse(String cid) {
		boolean result = false;
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			conn = DBGet.getConnection();
			stmt = conn.createStatement();		
			String sql = "SELECT * from courseplan where cid = '"+cid+"'";
			rs=stmt.executeQuery(sql);
			if(rs!=null && rs.next()){
				result = true;
			}		
		}catch (SQLException el) {
			System.out.println(el+"dao");
		}finally {
			DBGet.closeConnection(conn);
		}
		
		return result;
	}
	
	/*
	 * ��ѯ�ÿγ��Ƿ�����ʦ����
	 */
	public Teacher selTeaByCid(String cid) {

		Connection conn = null;
	
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String sql2 = null;
		Teacher teacher = new Teacher();
		String tid = null;
		try {
			conn = DBGet.getConnection();
			stmt = conn.createStatement();		
			String sql = "SELECT tid from courseplan where cid = '"+cid+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				tid = rs.getString("tid");
			}
			System.out.println("������Ľ�ʦ��ţ�"+tid);
			sql2 = "select * from teacher where tid = '"+tid+"'";
			rs2=stmt.executeQuery(sql2);
			
			if(rs2.next()) {
				teacher.setTid(rs2.getString("tid"));
				teacher.setTname(rs2.getString("tname"));
				teacher.setTpassword(rs2.getString("tpassword"));
				teacher.setTsex(rs2.getString("tsex"));
				teacher.setIntroduction(rs2.getString("introduction"));
			}
			
		}catch (SQLException el) {
			System.out.println(el+"dao");
		}finally {
			DBGet.closeConnection(conn);
		}
		
		return teacher;
	}
	
	
	/*
	 * ���ݿγ�����ѯ����ʵ����
	 */
	public Course getCouCid(String cid) {
		Course course = null;

		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from course where cid = '"+cid+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				course = new Course();
				course.setCid(rs.getString("cid"));
				course.setCname(rs.getString("cname"));
				course.setCintroduction(rs.getString("cintroduction"));
				course.setType(rs.getString("type"));
				course.setBelongcoll(rs.getString("belongcoll"));
				course.setBelongpro(rs.getString("belongpro"));
				
				
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return course;
	}
	
	
	
	/*
	 * ���ѡ����Ϣ
	 */
	
	public boolean selectCourse(String cid,String sid) {
		boolean result = false;
		Connection conn = null;
		int n = 0;
		try {
			conn = DBGet.getConnection();
			String sql="insert into sc values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setString(2, cid);
			ps.setString(3, sid);
			
			
			n=ps.executeUpdate();
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
	
	
	
	
	//ajax�γ̱���Ƿ����
		public boolean queryByCid(String cid) {
			boolean result = false;
			Connection conn = null;
			ResultSet rs = null;
			try {
				conn = DBGet.getConnection();
				String sql="select * from course where cid = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,cid);	
				rs = ps.executeQuery();
				//6.������
				if(rs!=null && rs.next()){
					result = true;
				}
			}catch (SQLException el) {
				System.out.println(el+"dao");
			}finally {
				DBGet.closeConnection(conn);
			}
			return result;
		}
	
}
