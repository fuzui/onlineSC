package net.fuzui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import net.fuzui.beans.Student;


public class StudentDAO {
	
	
	/*
	 * 学生登录
	 */
	public boolean queryByNamePwd(String sid,String up) {
		boolean result = false;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBGet.getConnection();
			String sql="select * from student where sid = ? and spassword= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,sid);
			ps.setString(2,up);
			
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
	 * 添加学生
	 */
	public boolean addStudent(Student student) {
		boolean result = false;
		Connection conn = null;
		int n = 0;
		try {
			conn = DBGet.getConnection();
			String sql="insert into student values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getSid());
			ps.setString(2, student.getSname());
			ps.setString(3, student.getSidcard());
			ps.setString(4, student.getSsex());
			ps.setString(5, student.getSpassword());
			ps.setString(6, student.getSage());
			ps.setString(7, student.getClassr());
			ps.setString(8, student.getProfession());
			ps.setString(9, student.getCollege());
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
	 * 查询全部学生
	 */
	public ArrayList<Student>getAllStudent() {
		Student student = null;
		ArrayList<Student>studentList = new ArrayList<Student>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from student";
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
	
	/*
	 * 根据学号查询
	 */
	public ArrayList<Student>getByStudentId(String sid) {
		Student student = null;
		ArrayList<Student>studentList = new ArrayList<Student>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from student where sid = '"+sid+"'";
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
	
	/*
	 * 根据学院查询
	 */	
	public ArrayList<Student>getByStudentCol(String college) {
		Student student = null;
		ArrayList<Student>studentList = new ArrayList<Student>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from student where college = '"+college+"'";
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
	
	/*
	 * 根据专业查询
	 */	
	public ArrayList<Student>getByStudentPro(String profession) {
		Student student = null;
		ArrayList<Student>studentList = new ArrayList<Student>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from student where profession = '"+profession+"'";
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
	
	/*
	 * 根据班级查询
	 */
	public ArrayList<Student>getByStudentCla(String classr) {
		Student student = null;
		ArrayList<Student>studentList = new ArrayList<Student>();
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from student where classr = '"+classr+"'";
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
	
	/*
	 * 修改学生信息
	 */
	public boolean modify(Student student) {
		boolean result = false;
		int n= 0;
		Connection conn =null;
		String sql = null;
		try {
			conn = DBGet.getConnection();
			sql="update student set sname=?,sidcard=?,ssex=?,spassword=?,sage=?,classr=?,profession=?,college=? where sid =?";
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ps.setString(1, student.getSname());
			ps.setString(2, student.getSidcard());
			ps.setString(3, student.getSsex());
			ps.setString(4, student.getSpassword());
			ps.setString(5, student.getSage());
			ps.setString(6, student.getClassr());
			ps.setString(7, student.getProfession());
			ps.setString(8, student.getCollege());
			ps.setString(9, student.getSid());
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
	 * 删除学生信息
	 */
	public boolean deleteStudent(String sid) {
		boolean result = false;
		Connection conn = null;
		int n = 0;
		
		try {
			conn = DBGet.getConnection();
				
			String sql="delete from student where sid= ?";
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ps.setString(1, sid);
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
	 * 通过学号查找姓名
	 */
	public Student getByStuSid(String sid) {
		Student student = null;
		
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try{
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * from student where sid ='"+sid+"'";
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
				
			}
		}catch (SQLException e1) {
			System.out.println(e1+"dao");
		}
		finally {
			DBGet.closeConnection(conn);
		}
		return student;
	}
	
	/*
	 * x学生修改密码
	 */
	public boolean modifyPw(String spassword,String sid) {
		boolean result = false;
		int n= 0;
		Connection conn =null;
		String sql = null;
		try {
			conn = DBGet.getConnection();
			sql="update student set spassword=? where sid =?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, spassword);
			ps.setString(2, sid);
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
	
	
	//ajax学号号是否存在
			public boolean queryBySid(String sid) {
				boolean result = false;
				Connection conn = null;
				ResultSet rs = null;
				try {
					conn = DBGet.getConnection();
					String sql="select * from Student where sid = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1,sid);	
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
