package tw.iiijdbc.conn.day3;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.text.Utilities;

import tw.iiijdbc.util.DbConnUtil;

public class Demo9SQLException {
	

	public static void main(String[] args) {
		DbConnUtil util = new DbConnUtil();//為甚麼要放這才讀的到: 因為他是main方法
		try {
			Connection conn = util.createSQLServerConn();
			System.out.println("Connection Success!!");
			conn.close();
		} catch (SQLException e) {
			System.out.println("e.getMessage(): " + e.getMessage());
			System.out.println("e.getErrorCode(): " + e.getErrorCode());
		}finally {
			
		}
		
	}

}
