package mid_exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Mid_Exam {

	private Connection conn;

	// 開連線
	public void createConn() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String urlString = "jdbc:sqlserver://localhost:1433;databaseName=iii;user=sa;password=1234567890";

		conn = DriverManager.getConnection(urlString);

		boolean status = !conn.isClosed();

		if (status) {
			System.out.println("Connection Open status:" + status);
		}

	}

	// 關連線
	public void closeConn() throws Exception {
		if (conn != null) {
			conn.close();
			System.out.println("Close Connection!!");
		}
	}

	// 新增table : vio_pension
	// insname事業單位名稱/負責人
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

	// 把csv檔讀入資料庫
	public void storeCSVtoDB() {
		try (FileInputStream fis1 = new FileInputStream("C:/java/公布109年4月至110年3月違反勞工退休金條例事業單位名單一覽表.csv");
				InputStreamReader isr1 = new InputStreamReader(fis1, "UTF8");
				BufferedReader br1 = new BufferedReader(isr1);) {

			String sqlStr = "Insert into vio_pension(insname,vio_regu,vio_cont,dis_num,dis_date,dis_fine,remark) values(?,?,?,?,?,?,?);";

			PreparedStatement preState = conn.prepareStatement(sqlStr);

			Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(isr1);

			for (CSVRecord exRrcord : records) {
				preState.setString(1, exRrcord.get(0));
				preState.setString(2, exRrcord.get(1));
				preState.setString(3, exRrcord.get(2));
				preState.setString(4, exRrcord.get(3));
				preState.setString(5, exRrcord.get(4));
				preState.setInt(6, Integer.valueOf(exRrcord.get(5)));
				if (exRrcord.get(6) == null) {
					preState.setNull(7, java.sql.Types.NVARCHAR);
				} else {
					preState.setString(7, exRrcord.get(6));
				}
				preState.execute();
			}

			preState.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// main方法操作
	public static void main(String[] args) {

		Mid_Exam midEx = new Mid_Exam();

		try {
			midEx.createConn();
			midEx.createTable();
			midEx.storeCSVtoDB();
		} catch (Exception e) {
			System.out.println("Something Wrong");
			e.printStackTrace();
		} finally {
			try {
				midEx.closeConn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
