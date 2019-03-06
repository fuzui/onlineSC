package net.fuzui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import net.fuzui.beans.CoursePlan;


public class CoursePlanDAO {
	
	/*
	 * 添加课程安排
	 */
	public boolean addCoursePlan(CoursePlan coursePlan) {
		boolean result = false;
		Connection conn = null;
		int n = 0;
		try {
			conn = DBGet.getConnection();
			String sql="insert into courseplan values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, coursePlan.getCourseclass());
			ps.setString(2, coursePlan.getCoursetime());
			ps.setString(3, coursePlan.getCourseweek());
			ps.setString(4, coursePlan.getCid());
			ps.setString(5, coursePlan.getTid());
			ps.setString(6,coursePlan.getClassroom());
			ps.setString(7, coursePlan.getCredits());
			ps.setString(8, coursePlan.getPeriod());
			ps.setString(9,coursePlan.getTotalnum());
			
			System.out.println(sql);
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
	 * 根据课程班级查询选课
	 */
	public ArrayList<CoursePlan>getByCouPlanName(String courseclass) {
		CoursePlan coursePlan = null;
		ArrayList<CoursePlan>coursePlanList = new ArrayList<CoursePlan>();
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from courseplan where courseclass = '"+courseclass+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				coursePlan = new CoursePlan();
				coursePlan.setCourseclass(rs.getString("courseclass"));
				coursePlan.setCoursetime(rs.getString("coursetime"));
				coursePlan.setCourseweek(rs.getString("courseweek"));
				coursePlan.setCid(rs.getString("cid"));
				coursePlan.setTid(rs.getString("tid"));
				coursePlan.setClassroom(rs.getString("classroom"));
				coursePlan.setCredits(rs.getString("credits"));
				coursePlan.setPeriod(rs.getString("period"));
				coursePlan.setTotalnum(rs.getString("totalnum"));
				coursePlanList.add(coursePlan);
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return coursePlanList;
	}
	
	/*
	 * 根据课程班级查询选课
	 */
	public ArrayList<CoursePlan>getByCouPlanTid(String tid) {
		CoursePlan coursePlan = null;
		ArrayList<CoursePlan>coursePlanList = new ArrayList<CoursePlan>();
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from courseplan where tid = '"+tid+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				coursePlan = new CoursePlan();
				coursePlan.setCourseclass(rs.getString("courseclass"));
				coursePlan.setCoursetime(rs.getString("coursetime"));
				coursePlan.setCourseweek(rs.getString("courseweek"));
				coursePlan.setCid(rs.getString("cid"));
				coursePlan.setTid(rs.getString("tid"));
				coursePlan.setClassroom(rs.getString("classroom"));
				coursePlan.setCredits(rs.getString("credits"));
				coursePlan.setPeriod(rs.getString("period"));
				coursePlan.setTotalnum(rs.getString("totalnum"));
				coursePlanList.add(coursePlan);
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return coursePlanList;
	}
	
	
	/*
	 * 修改课程安排
	 */
	
	public boolean modify(CoursePlan coursePlan) {
		boolean result = false;
		int n= 0;
		Connection conn =null;
		String sql = null;
		try {
			conn = DBGet.getConnection();
			sql="update courseplan set coursetime=?,courseweek=?,cid=?,tid=?,classroom=?,credits=?,period=?,totalnum=? where courseclass =?";
			PreparedStatement ps =conn.prepareStatement(sql);
			
	
			ps.setString(1, coursePlan.getCoursetime());
			ps.setString(2, coursePlan.getCourseweek());
			ps.setString(3, coursePlan.getCid());
			ps.setString(4, coursePlan.getTid());
			ps.setString(5, coursePlan.getClassroom());
			ps.setString(6, coursePlan.getCredits());
			ps.setString(7, coursePlan.getPeriod());
			ps.setString(8, coursePlan.getTotalnum());
			ps.setString(9, coursePlan.getCourseclass());
			System.out.println(sql);
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
	
	
	public boolean delByCouPlanClass(String courseclass) {
		boolean result = false;
		int n= 0;
		Connection conn =null;
		String sql = null;
		try {
			conn = DBGet.getConnection();
			sql="delete from courseplan where courseclass= ?";
			PreparedStatement ps =conn.prepareStatement(sql);
			
	
			ps.setString(1, courseclass);
			
			System.out.println(sql);
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
	
	
	
	
	//ajax查询该时间点该教室是否重合
			public boolean queryBy(String coursetime,String courseweek,String classroom) {
				boolean result = false;
				Connection conn = null;
				ResultSet rs = null;
				try {
					conn = DBGet.getConnection();
					String sql="select * from courseplan where coursetime=? and courseweek=? and classroom=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1,coursetime);	
					ps.setString(2,courseweek);	
					ps.setString(3,classroom);	
					rs = ps.executeQuery();
					//6.处理结果
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
