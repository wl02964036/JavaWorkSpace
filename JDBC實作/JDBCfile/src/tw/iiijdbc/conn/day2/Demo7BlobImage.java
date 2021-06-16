package tw.iiijdbc.conn.day2;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo7BlobImage {
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
		
		//把圖片存到資料庫
		public void storeImageFileToDB() throws Exception {
			File myfile = new File("C:/JDBCfile/temp/kuso.jpg");
			FileInputStream fis1 = new FileInputStream(myfile);
			String sqlStr = "Insert into Gallery(imageName,imageFile) Values(?,?)";
			
			PreparedStatement preState = conn.prepareStatement(sqlStr);
			
			preState.setString(1, "kuso");
			preState.setBinaryStream(2, fis1);
			
			preState.execute();
			
			preState.close();
			fis1.close();
			
			System.out.println("store file OK!!");
		}
		
		//從資料庫中取出圖片，並儲存在特定位置
		public void getImageFromDB() throws SQLException, IOException {
			String sqlStr = "Select * from Gallery where id = ?";
			PreparedStatement preState = conn.prepareStatement(sqlStr);
			preState.setInt(1, 1);
			
			ResultSet rs = preState.executeQuery();
			rs.next();
			Blob blob = rs.getBlob(3);//讀取Gallery table的第三個欄位,也就是放圖檔的欄位
			blob.length();
			System.out.println("blob.length():"+blob.length());
			
//			FileOutputStream fos1 = new FileOutputStream("C:/JDBCfile/temp/out/kuso2.jpg");
//			BufferedOutputStream bos = new BufferedOutputStream(fos1);
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:/JDBCfile/temp/out/kuso2.jpg"));
			bos.write(blob.getBytes(1, (int)blob.length()));
			
			bos.flush();//強制寫出記憶體
			
			bos.close();
			rs.close();
			preState.close();
			
			System.out.println("Get Image Success!!");
		}
	
	
	
	public static void main(String[] args) {
		Demo7BlobImage demo7 = new Demo7BlobImage();
		
		try {
			demo7.createConn();
			
			demo7.storeImageFileToDB();
//			demo7.getImageFromDB();
			
		} catch (Exception e) {
			System.out.println("Some Error :"+ e );
		}finally {
			try {
				demo7.closeConn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
