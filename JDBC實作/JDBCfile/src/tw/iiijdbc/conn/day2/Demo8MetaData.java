package tw.iiijdbc.conn.day2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import tw.iiijdbc.util.DbConnUtil;

public class Demo8MetaData {
	
	private DbConnUtil dbUtil = new DbConnUtil();
	
	private Connection conn;
	
	public void getConn() {
		try {
			conn = dbUtil.createSQLServerConn();
			System.out.println("Connection Success!!");
		} catch (Exception e) {
			System.out.println("==== Connection Fail ====");
			e.printStackTrace();
		}
	}
	
	public void closeConn() {
		try {
			dbUtil.closeConn();
			System.out.println("Close Connection Success!!");
		} catch (SQLException e) {
			System.out.println("Close Connection Fail!!");
			e.printStackTrace();
		}
	}
	
	public void getDbMetaData() throws SQLException {
		DatabaseMetaData metaData = conn.getMetaData();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("資料庫名稱:" + metaData.getDatabaseProductName());
		sb.append("\n資料庫版本"+metaData.getDatabaseProductVersion());
		sb.append("\n驅動程式名稱:" + metaData.getDriverName());
		sb.append("\n驅動版本:" + metaData.getDriverVersion());
		sb.append("\n DBMS 的 URL:" + metaData.getURL());//DataBase Management System
		sb.append("\n使用者名稱" + metaData.getUserName());
		
		System.out.println(sb.toString());
		
	}
	
	//ResultSetMetaData 實作
	public void getTableMetaData() throws SQLException {
		
		String sqlStr = "Select * from Product"; 
		
		PreparedStatement preState = conn.prepareStatement(sqlStr);
		
		ResultSet rs = preState.executeQuery();
		ResultSetMetaData metadata = rs.getMetaData();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("ColumnCount: " + metadata.getColumnCount());
		sb.append("\nColumnName(1) "+ metadata.getColumnName(1));
		sb.append("\nColumnName(2) "+ metadata.getColumnName(2));
		sb.append("\nColumnType(1) "+ metadata.getColumnType(1));
		sb.append("\nColumnTypeName(1) "+ metadata.getColumnTypeName(1));
		sb.append("\nColumnDisplaySize(1) "+ metadata.getColumnDisplaySize(1));
		
		System.out.println(sb.toString());
		
		rs.close();
		preState.close();
	}
	
	
	public static void main(String[] args) throws SQLException {

		Demo8MetaData demo8 = new Demo8MetaData();
		demo8.getConn();
//		demo8.getDbMetaData();
		demo8.getTableMetaData();
		
		demo8.closeConn();
		
		
		
	}

}
