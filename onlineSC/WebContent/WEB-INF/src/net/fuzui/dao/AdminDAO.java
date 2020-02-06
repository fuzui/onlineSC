package net.fuzui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminDAO {
	
	/*
	 * 管理员登录
	 */
	public boolean queryByNamePwd(String aname,String up) {
		boolean result = false;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBGet.getConnection();
			String sql="select * from `admin` where aname = ? and apassword= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,aname);
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
	
	

	
}
