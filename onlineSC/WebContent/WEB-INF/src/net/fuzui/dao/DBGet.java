package net.fuzui.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBGet {
	static String sDBDriver = "com.mysql.jdbc.Driver";
	static String sConnStr = "jdbc:mysql://localhost:3306/selc?useUnicode=true&characterEncoding=utf-8";
	static String username = "root";
	static String password = "root";
	
	//返回Connection对象
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(sDBDriver);
			//创建数据库连接
			conn = DriverManager.getConnection(sConnStr, username, password);
		}catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch (SQLException ex) {
			System.out.println(ex.getMessage()+"b=dbget");
		}
		return conn;
	}
	
	//关闭Connection对象
	public static void closeConnection(Connection conn) {
		try {
			if (conn!=null) {
				conn.close();
			}
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
}
