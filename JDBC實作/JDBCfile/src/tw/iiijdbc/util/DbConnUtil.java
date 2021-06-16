package tw.iiijdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnUtil {
	
	private Connection conn;
	//public Connection裡的Connection是甚麼意思: 他是方法型態，只要是return都要寫
	public Connection createSQLServerConn() throws SQLException {
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String urlStr = "jdbc:sqlserver://localhost:1433;databaseName=JDBCDemoDB;user=sa;password=garyz26598";
		
		conn = DriverManager.getConnection(urlStr);
		return conn;//指回傳conn這參數，傳到createSQLServerConn()這方法上
	}
	
	public void closeConn() throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
}
