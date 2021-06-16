package mid_exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Mid_Exam_Scanner {
	
	private Connection conn;
	
	Scanner scanner = new Scanner(System.in); 
	
	// 開連線
			public void createConn() throws SQLException {
				String urlString = "jdbc:sqlserver://localhost:1433;databaseName=iii;user=sa;password=1234567890";
				conn = DriverManager.getConnection(urlString);
				boolean status = !conn.isClosed();
				System.out.println("Connection Open status:" + status);
			}
			
			
			// 關連線
			public void closeConn() throws SQLException {
				if (conn != null) {
					conn.close();
					System.out.println("Close Connection!!");
				}
			}
			
			
			//新增資料方法
			public void scanner_AddMid_Exam_Getset(Mid_Exam_Getset meg) throws SQLException {
				String sqlStr = "insert into vio_pension values(?,?,?,?,?,?,?)";
				PreparedStatement preState = conn.prepareStatement(sqlStr);
				preState.setString(1, meg.getInsname());
				preState.setString(2, meg.getVio_regu());
				preState.setString(3, meg.getVio_cont());
				preState.setString(4, meg.getDis_num());
				preState.setString(5, meg.getDis_date());
				preState.setInt(6, meg.getDis_fine());
				preState.setString(7, meg.getRemark());
				preState.executeUpdate();
				
				preState.close();

				
			}
			
			
			//修改資料方法
			public void updateByDis_Num(Mid_Exam_Getset meg) throws SQLException {
				String sqlStr = "update vio_pension set insname=?,vio_regu=?,vio_cont=?,dis_date=?,dis_fine=?,remark=? where dis_num=?";
				PreparedStatement preState = conn.prepareStatement(sqlStr);
				preState.setString(1, meg.getInsname());
				preState.setString(2, meg.getVio_regu());
				preState.setString(3, meg.getVio_cont());
				preState.setString(4, meg.getDis_date());
				preState.setInt(5, meg.getDis_fine());
				preState.setString(6, meg.getRemark());
				preState.setString(7, meg.getDis_num());
				preState.executeUpdate();
				
				preState.close();

			}
			
			
			
			//刪除資料方法
			public void deleteByDis_Num(Mid_Exam_Getset meg) throws SQLException {
				String sqlStr = "delete from vio_pension where dis_num=?";
				PreparedStatement preState = conn.prepareStatement(sqlStr);
				preState.setString(1, meg.getDis_num());
				preState.executeUpdate();
				
				preState.close();

			}
			
			
			//查詢資料方法
			public void findByDis_Num(Mid_Exam_Getset meg) throws SQLException {
				String sqlStr = "select insname,vio_regu,vio_cont,dis_num,convert(date,dis_date) dis_date,dis_fine,remark from vio_pension where dis_num=?";
				PreparedStatement preState = conn.prepareStatement(sqlStr);
				preState.setString(1, meg.getDis_num());
				ResultSet rs = preState.executeQuery();
				while(rs.next()) {
					meg = new Mid_Exam_Getset();
					meg.setInsname(rs.getString("insname"));
					meg.setVio_regu(rs.getString("vio_regu"));
					meg.setVio_cont(rs.getString("vio_cont"));
					meg.setDis_num(rs.getString("dis_num"));
					meg.setDis_date(rs.getString("dis_date"));
					meg.setDis_fine(rs.getInt("dis_fine"));
					meg.setRemark(rs.getString("remark"));
					System.out.printf("事業單位名稱/負責人:%s\r\n違反法規條款:%s\r\n違反法規內容:%s\r\n處分字號:%s\r\n處分日期:%s\r\n處分金額:%8d\r\n備註:%s\r\n",meg.getInsname(),meg.getVio_regu(),meg.getVio_cont(),meg.getDis_num(),meg.getDis_date(),meg.getDis_fine(),meg.getRemark());
					
				}
				
				
				rs.close();
				preState.close();
			}
			
			
}

