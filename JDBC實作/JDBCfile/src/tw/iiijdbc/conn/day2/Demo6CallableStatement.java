package tw.iiijdbc.conn.day2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo6CallableStatement {
	
	private Connection conn;
	
	//開連線
	public void createConn() throws Exception {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String urlString = "jdbc:sqlserver://localhost:1433;databaseName=JDBCDemoDB;user=sa;password=garyz26598";
			String url2 = "jdbc:sqlserver://Student-PC\\SQLEXPRESS:1433;databaseName=JDBCDemoDB;user=sa;password=garyz26598";
			
			conn = DriverManager.getConnection(urlString);

			boolean status = !conn.isClosed();

			if (status) {
				System.out.println("Connection Open status: " + status);
			}

		}
	// 關連線
		public void closeConn() throws Exception {
			if (conn != null) {
				conn.close();
				System.out.println("Close connection!!");
			}
		}
		
		//呼叫stored procedure
		public void callProcdeure() throws SQLException {
			CallableStatement callState = conn.prepareCall("{call productProc(?,?)}");
			callState.setInt(1, 1002);
			callState.registerOutParameter(2, java.sql.Types.VARCHAR);
			
			callState.execute();
			
			String productName = callState.getString(2);
			System.out.println("My productName:"+productName);
			
			callState.close();
		}

	public static void main(String[] args) {
		Demo6CallableStatement demo6 = new Demo6CallableStatement();
		
		try {
			demo6.createConn();
			
			demo6.callProcdeure();
			
		} catch (Exception e) {
			System.out.println("Something Wrong!!");
			e.printStackTrace();
		}finally {
			try {
				demo6.closeConn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
