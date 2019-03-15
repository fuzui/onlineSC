package net.fuzui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import net.fuzui.beans.Teacher;



public class TeacherDAO {
	
	/*
	 * 教师登录
	 */
	public boolean queryByNamePwd(String tid,String up) {
		boolean result = false;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBGet.getConnection();
			String sql="select * from teacher where tid = ? and tpassword= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,tid);
			ps.setString(2,up);
			System.out.println(sql);
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
	
	/*
	 * 添加教师
	 */
	public boolean addTeacher(Teacher teacher) {
		boolean result = false;
		Connection conn = null;
		int n = 0;
		try {
			conn = DBGet.getConnection();
			String sql="insert into teacher values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, teacher.getTid());
			ps.setString(2, teacher.getTname());
			ps.setString(3, teacher.getTpassword());
			ps.setString(4, teacher.getTsex());
			ps.setString(5, teacher.getIntroduction());
			
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
	 * 查询全部教师
	 */
	public ArrayList<Teacher>getAllTeacher() {
		Teacher teacher = null;
		ArrayList<Teacher>teacherList = new ArrayList<Teacher>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from teacher";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				teacher = new Teacher();
				teacher.setTid(rs.getString("tid"));
				teacher.setTname(rs.getString("tname"));
				teacher.setTpassword(rs.getString("tpassword"));
				teacher.setTsex(rs.getString("tsex"));
				teacher.setIntroduction(rs.getString("introduction"));
				
				
				teacherList.add(teacher);
				
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return teacherList;
	}
		
	/*
	 * 根据教师编号查询
	 */
	public ArrayList<Teacher>getTeacherTid(String tid) {
		Teacher teacher = null;
		ArrayList<Teacher>teacherList = new ArrayList<Teacher>();
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from teacher where tid ='"+tid+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				teacher = new Teacher();
				teacher.setTid(rs.getString("tid"));
				teacher.setTname(rs.getString("tname"));
				teacher.setTpassword(rs.getString("tpassword"));
				teacher.setTsex(rs.getString("tsex"));
				teacher.setIntroduction(rs.getString("introduction"));
				teacherList.add(teacher);
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return teacherList;
	}
	
	/*
	 * 修改教师信息
	 */
	public boolean modify(Teacher teacher) {
		boolean result = false;
		int n= 0;
		Connection conn =null;
		String sql = null;
		try {
			conn = DBGet.getConnection();
			sql="update teacher set tname=?,tpassword=?,tsex=?,introduction=? where tid =?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, teacher.getTname());
			ps.setString(2, teacher.getTpassword());
			ps.setString(3, teacher.getTsex());
			ps.setString(4, teacher.getIntroduction());
			ps.setString(5, teacher.getTid());
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
	 * 删除教师信息
	 */
	public boolean deleteTeacher(String tid) {
		boolean result = false;
		Connection conn = null;
		int n = 0;
		Statement stmt = null;
		try {
			conn = DBGet.getConnection();
			stmt = conn.createStatement();		
			String sql="delete from teacher where tid="+tid;
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
	 * 根据教师编号查询
	 */
	public Teacher getByTeaTid(String tid) {
		Teacher teacher = null;
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from teacher where tid ='"+tid+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				teacher = new Teacher();
				teacher.setTid(rs.getString("tid"));
				teacher.setTname(rs.getString("tname"));
				teacher.setTpassword(rs.getString("tpassword"));
				teacher.setTsex(rs.getString("tsex"));
				teacher.setIntroduction(rs.getString("introduction"));
				
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return teacher;
	}
	
	/*
	 * 教师修改密码
	 */
	public boolean modifyPw(String tpassword,String tid) {
		boolean result = false;
		int n= 0;
		Connection conn =null;
		String sql = null;
		try {
			conn = DBGet.getConnection();
			sql="update teacher set tpassword=? where tid =?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, tpassword);
			ps.setString(2, tid);
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
	
	
	//ajax教师工号是否存在
			public boolean queryByTid(String tid) {
				boolean result = false;
				Connection conn = null;
				ResultSet rs = null;
				try {
					conn = DBGet.getConnection();
					String sql="select * from teacher where tid = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1,tid);	
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
