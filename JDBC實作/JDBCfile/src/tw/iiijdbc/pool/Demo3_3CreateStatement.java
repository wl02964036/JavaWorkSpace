package tw.iiijdbc.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariDataSource;

public class Demo3_3CreateStatement {
	
	private Connection conn;
	
	private HikariUtil connPool = new HikariUtil();
	
	
	//開連線
	public void createConn() throws Exception{
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		String urlString = "jdbc:sqlserver://localhost:1433;databaseName=JDBCDemoDB;user=sa;password=garyz26598";
//		String url2 = "jdbc:sqlserver://Student-PC\\SQLEXPRESS:1433;databaseName=JDBCDemoDB;user=sa;password=garyz26598";
		
//		conn = DriverManager.getConnection(urlString);
//		Connection conn = DriverManager.getConnection(url2);
		
		HikariDataSource ds = connPool.openDataSource();
		conn = ds.getConnection();
		
		boolean status = !conn.isClosed();
		
		if(status) {
			System.out.println("Connection Open status: " + status);
		}
		
	}
	//關連線
	public void closeConn() throws Exception {
		if(conn !=null) {
			conn.close();
			System.out.println("Close connection!!");
			connPool.closeDataSource();
			System.out.println("Close HikariDataSource!!");
		}
	}
	
	//查找有無資料
	public void queryDB1() throws SQLException {
		String sqlStr = "Select * from product";
		Statement stamt = conn.createStatement();
		ResultSet rs = stamt.executeQuery(sqlStr);
		System.out.println("Data Result:"+rs.next());
		rs.close();
		stamt.close();
	}
	
	//查找有無資料
	public void queryDB2() throws SQLException {
		String sqlStr = "Select * from Product";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sqlStr);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			System.out.println("============================");
		}
		
		rs.close();
		stmt.close();
	}
	
	//更新資料
	public void updateData() throws SQLException {
		String sqlStr ="Update Product Set productprice = 60 where productname = 'mask'";
		Statement state =conn.createStatement();
		int row = state.executeUpdate(sqlStr);
		System.out.println("Update product success:"+row+"筆資料");
		
		state.close();
	}
	
	//新增一筆資料
	public void insertData() throws SQLException {
		String sqlstr = "Insert Into Product(productid,productname,productprice,productdate,remark)"+
						"Values(1005,'switch',12000,'2021-05-31','discount')";
		Statement state =conn.createStatement();
		state.execute(sqlstr);
		System.out.println("Insert Product Success");
		state.close();
	}
	
	//刪除一筆資料
	public void deleteOneData() throws SQLException {
		String sqlStr = "Delete Product Where productid = 1001";
		Statement state = conn.createStatement();
		int row = state.executeUpdate(sqlStr);
		System.out.println("Delete" + row + "Data");
	}
	
	//主程式
	public static void main(String[] args) {
			Demo3_3CreateStatement demo3 = new Demo3_3CreateStatement();
		
		try {
			demo3.createConn();
//			demo3.queryDB1();
			demo3.queryDB2();
//			demo3.updateData();
//			demo3.insertData();
//			demo3.deleteOneData();
		}catch(Exception e ) {
			System.out.println("Something Wrong!!");
			e.printStackTrace();
		}finally {
			try {
				demo3.closeConn();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		

		
	}

}