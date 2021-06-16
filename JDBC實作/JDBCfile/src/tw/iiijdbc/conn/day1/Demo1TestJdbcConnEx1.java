package tw.iiijdbc.conn.day1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Demo1TestJdbcConnEx1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String urlString = "jdbc:sqlserver://localhost:1433;databaseName=JDBCDemoDB;user=sa;password=garyz26598";
			String url2 = "jdbc:sqlserver://Student-PC\\SQLEXPRESS:1433;databaseName=JDBCDemoDB;user=sa;password=garyz26598";//;integratedSecurity=true是指用window驗證進入,i,e,不用打密碼
			
			Connection conn = DriverManager.getConnection(urlString);
//			Connection conn = DriverManager.getConnection(url2);
			
			boolean status = !conn.isClosed();
			
			System.out.println("Connection Open status: " + status);
			
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("=== Something Wrong!!! ===");
			e.printStackTrace();
		}

	}

}