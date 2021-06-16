package mid_exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Mid_Exam_DAO {

	private Connection conn;
	
	public Mid_Exam_DAO() {
		
	}
	
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
		
		
		// 新增table : vio_pension
		// insname 事業單位名稱/負責人
		// vio_regu 違反法規條款
		// vio_cont 違反法規內容
		// dis_num 處分字號
		// dis_date 處分日期
		// dis_fine 處分金額
		// remark 備註
		public void createTable() {
			String sqlStr = "create table vio_pension(insname nvarchar(40) not null,vio_regu nvarchar(30) not null,vio_cont nvarchar(40) not null,"
					+ "dis_num nvarchar(30) primary key,dis_date datetime,dis_fine int,remark nvarchar(30));";
			try {
				PreparedStatement prestate = conn.prepareStatement(sqlStr);
				prestate.execute();
				prestate.close();

				System.out.println("Create Table Success!!");

			} catch (SQLException e) {
				System.out.println("Create Table Fail!!");
				e.printStackTrace();
			}
		}
		
		
		//新增CSV方法
		public void addCSVtoDB() {
			Mid_Exam_Getset meg = new Mid_Exam_Getset();
			try (FileInputStream fis1 = new FileInputStream("C:/java/公布109年4月至110年3月違反勞工退休金條例事業單位名單一覽表.csv");
					InputStreamReader isr1 = new InputStreamReader(fis1, "UTF8");
					BufferedReader br1 = new BufferedReader(isr1);) {

				String sqlStr = "Insert into vio_pension(insname,vio_regu,vio_cont,dis_num,dis_date,dis_fine,remark) values(?,?,?,?,?,?,?);";
				
				PreparedStatement preState = conn.prepareStatement(sqlStr);
				
				Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(isr1);
				
				
				for(CSVRecord exRecord : records) {
					meg.setInsname(exRecord.get(0));
					meg.setVio_regu(exRecord.get(1));
					meg.setVio_cont(exRecord.get(2));
					meg.setDis_num(exRecord.get(3));
					meg.setDis_date(exRecord.get(4));
					meg.setDis_fine(Integer.parseInt(exRecord.get(5)));
					meg.setRemark(exRecord.get(6));
					preState.setString(1, meg.getInsname());
					preState.setString(2, meg.getVio_regu());
					preState.setString(3, meg.getVio_cont());
					preState.setString(4, meg.getDis_num());
					preState.setString(5, meg.getDis_date());
					preState.setInt(6, meg.getDis_fine());
					if (exRecord.get(6) == null) {
						preState.setNull(7, java.sql.Types.NVARCHAR);
					}else {
						preState.setString(7, exRecord.get(6));
					}
					preState.execute();
				}
	 
				
				preState.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//從資料庫中讀取CSV，並儲存在特定位置
		public List<Mid_Exam_Getset> getCSVfromDB() throws SQLException, IOException {
			List<Mid_Exam_Getset> list_Meg = new ArrayList<>();
			String sqlStr = "select insname,vio_regu,vio_cont,dis_num,convert(date,dis_date) dis_date,dis_fine,remark from vio_pension";
			PreparedStatement preState = conn.prepareStatement(sqlStr);
			ResultSet rs = preState.executeQuery();
			while(rs.next()) {
				Mid_Exam_Getset meg = new Mid_Exam_Getset();
				meg.setInsname(rs.getString("insname"));
				meg.setVio_regu(rs.getString("vio_regu"));
				meg.setVio_cont(rs.getString("vio_cont"));
				meg.setDis_num(rs.getString("dis_num"));
				meg.setDis_date(rs.getString("dis_date"));
				meg.setDis_fine(rs.getInt("dis_fine"));
				meg.setRemark(rs.getString("remark"));
				
				list_Meg.add(meg);
			}
			
			rs.close();
			preState.close();
			
			return list_Meg;
			
		}
		
	
		

/*	
		//修改欄位//失敗
		public void updateColumnName(Mid_Exam_Getset meg) throws SQLException {
			String sqlStr = "exec sp_rename vio_pension.?,?,column;";
			PreparedStatement preState = conn.prepareStatement(sqlStr);
			preState.setString(1, meg.getOldColname());
			preState.setString(2, meg.getNewColname());
			preState.execute();
			preState.close();
		}
*/
		
		
		
		
		//查詢資料方法
		public Mid_Exam_Getset findByDisNum(String dis_num) throws SQLException {
			String sqlStr = "select insname,vio_regu,vio_cont,dis_num,convert(date,dis_date) dis_date,dis_fine,remark from vio_pension where dis_num = ?";
			PreparedStatement preState = conn.prepareStatement(sqlStr);
			preState.setString(1, dis_num);
			ResultSet rs = preState.executeQuery();
			
			Mid_Exam_Getset meg = null;
			
			if (rs.next()) {
				meg = new Mid_Exam_Getset();
				meg.setInsname(rs.getString("insname"));
				meg.setVio_regu(rs.getString("vio_regu"));
				meg.setVio_cont(rs.getString("vio_cont"));
				meg.setDis_num(rs.getString("dis_num"));
				meg.setDis_date(rs.getString("dis_date"));
				meg.setDis_fine(rs.getInt("dis_fine"));
				meg.setRemark(rs.getString("remark"));
				
				
			}
			
			rs.close();
			preState.close();
			return meg;
		}
		

}
