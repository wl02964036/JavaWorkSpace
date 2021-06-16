package tw.iiijdbc.conn.day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo5SqlInjection {

	
		
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
			
			// 用 createStatement 登入
			public boolean checkLogin(String userName, String userPwd) throws SQLException {
				String sqlStr = "Select * from Users Where username='" +userName +"' and userPwd='"+userPwd +"'";
				//單引號是SQL的單引號，雙引號是Java要把兩邊串接起來
				System.out.println("sqlStr = " + sqlStr);
				
				Statement creState = conn.createStatement();
				
				ResultSet rs = creState.executeQuery(sqlStr);
				
				boolean checkOK = rs.next();
				
				rs.close();
				creState.close();
				
				return checkOK;
			}
			
			//用prerpareStatement避免checkLogin的情況(就是不用單引號跟雙引號混著用)//3-1
			public boolean checkLogin_1(String userName,String userPwd) throws SQLException {
				String sqlStr_1 = "Select * from Users where username = ? and userPwd = ?";
				
				System.out.println("sqlStr_1 = " + sqlStr_1);
				
				PreparedStatement preState = conn.prepareStatement(sqlStr_1);
				preState.setString(1, userName);
				preState.setString(2, userPwd);
				
				ResultSet rs = preState.executeQuery();
				
				boolean checkOk2 = rs.next();
				
				rs.close();
				preState.close();
				
				return checkOk2;
			}
			
			public static void main(String[] args) {
				Demo5SqlInjection demo5 = new Demo5SqlInjection();
				
				String loginUser = "' or 2=2 --";//2-2
				String loginPwd = "11111";//2-2
				
				String loginUser_1 = "Mary";//3-2
				String loginPwd_1 = "Qwert";//3-2
				
				try {
					demo5.createConn();
//					boolean result = demo5.checkLogin(loginUser, loginPwd);//2-1
//					boolean result = demo5.checkLogin("Jerry", "123456");//1-1
					boolean result = demo5.checkLogin_1(loginUser, loginPwd);//3-3
					
					if(result) {
						System.out.println("登入成功");
					} else {
						System.out.println("帳號密碼錯誤，登入失敗");
					}
					
				}catch(Exception e) {
					System.out.println("Something Wrong!!");
					e.printStackTrace();
				} finally {
					try {
						demo5.closeConn();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}

		}