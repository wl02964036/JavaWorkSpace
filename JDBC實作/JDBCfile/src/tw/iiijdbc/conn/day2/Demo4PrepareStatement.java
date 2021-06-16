package tw.iiijdbc.conn.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo4PrepareStatement {
		
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
		
		//新增表格
		public void createTable() {
			String sqlStr = "create table profiles(id int primary key not null identity(101,1),name varchar(30) not null,"
					+"address varchar(50) not null,phone varchar(20))";
			try {
				PreparedStatement prestate =conn.prepareStatement(sqlStr);
				prestate.execute();
				prestate.close();
				
				System.out.println("Create Table Success!!");
			}catch(SQLException e) {
				System.out.println("Create Table Fail!!");
				e.printStackTrace();
			}
		}
		
		//新增一筆資料,用prepare statement
		public void insertData() {
			String sqlStr = "Insert Into profiles(name,address,phone)Values(?,?,?)";
			try {
				PreparedStatement prestate =conn.prepareStatement(sqlStr);
				prestate.setString(1, "Mary");
				prestate.setString(2, "Japan");
				prestate.setString(3, "123-456-789");
				
				prestate.executeUpdate();
				prestate.close();
				System.out.println("Insert Data Success!!");
			} catch (SQLException e) {
				System.out.println("Insert Data File!!");
				e.printStackTrace();
			}
		}
		
		//修改資料,用prepareStatement
		public void updateData() throws SQLException {
			String sqlStr = "Update profiles where name =? and addres =?";
			PreparedStatement prestate=conn.prepareStatement(sqlStr);
			prestate.setString(1, "555-555-555");
			prestate.setString(2, "Mary");
			prestate.setString(3, "Japan");
			
			int row = prestate.executeUpdate();
			System.out.println("Update profile count:"+row);
			prestate.close();
		}

		//有條件尋找資料
		public void queryByAddress(String location) throws SQLException {
			String sqlStr = "Select * from profiles where address=?";
			
			PreparedStatement preState = conn.prepareStatement(sqlStr);
			
			preState.setString(1, location);
			
			boolean isQuery = preState.execute();
			ResultSet rs = preState.getResultSet();
			
			System.out.println("Query?" + isQuery);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			
			rs.close();
			preState.close();
		}
		
		//作業 Delete by id
		
		
		public static void main(String[] args) {
			
			Demo4PrepareStatement demo4 = new Demo4PrepareStatement();
			
			try {
				demo4.createConn();
//				demo4.createTable();
//				demo4.insertData();
//				demo4.updateData();
				demo4.queryByAddress("Japan");
				
			}catch(Exception e) {
				System.out.println("Something Wrong");
				e.printStackTrace();
				
			} finally {
				
				try {
					demo4.closeConn();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	}