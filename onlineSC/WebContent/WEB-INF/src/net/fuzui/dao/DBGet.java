package net.fuzui.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBGet {
	static String sDBDriver = "com.mysql.cj.jdbc.Driver";
	static String sConnStr = "jdbc:mysql://127.0.0.1:3306/selc?serverTimezone=UTC&allowPublicKeyRetrieval=true&characterEncoding=utf-8&useSSL=false&autoReconnect=true&allowMultiQueries=true";
	static String username = "student";
	static String password = "root";
	
	//����Connection����
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(sDBDriver);
			//�������ݿ�����
			conn = DriverManager.getConnection(sConnStr, username, password);
		}catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch (SQLException ex) {
			System.out.println(ex.getMessage()+"b=dbget");
		}
		return conn;
	}
	
	//�ر�Connection����
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
