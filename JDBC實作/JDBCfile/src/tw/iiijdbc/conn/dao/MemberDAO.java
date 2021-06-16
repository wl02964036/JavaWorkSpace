package tw.iiijdbc.conn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	
	private Connection conn;

	
	public MemberDAO() {
		
	}

	
	//開連線
	
	public void createConn() throws SQLException {
		String urlString = "jdbc:sqlserver://localhost:1433;databaseName=JDBCDemoDB;user=sa;password=garyz26598";
		conn = DriverManager.getConnection(urlString);
		boolean status = !conn.isClosed();
		System.out.println("Connection Open Status: " + status);
	}
	
	
	//關連線
	public void closeConn() throws SQLException {
		if(conn != null) {
			conn.close();
			System.out.println("Close Connection Finish!!");
		}
	}

	
	//新增資料方法
	public void addMember(Member m) throws SQLException {
		String sqlStr = "Insert into Member(id,name,address,phone) values(?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sqlStr);
		preState.setInt(1, m.getMemberId());
		preState.setString(2, m.getMemberName());
		preState.setString(3, m.getMemberAddress());
		preState.setString(4, m.getPhone());
		preState.execute();
		preState.close();
	}
	
	
	//修改資料方法
	public void updateByIdAndName(Member m) throws SQLException {
		String sqlStr = "Update Member Set address = ?,phone = ? where id = ? and name = ?";
		PreparedStatement PreState = conn.prepareStatement(sqlStr);
		PreState.setString(1, m.getMemberAddress());
		PreState.setString(2, m.getPhone());
		PreState.setInt(3, m.getMemberId());
		PreState.setString(4, m.getMemberName());
		PreState.execute();		
		PreState.close();
	}

	
	//查詢資料方法
	public Member findById(int id) throws SQLException { //如果很多member要用泛型:public List<Member> findById(int id)...
		String sqlStr = "Select * from Member where id = ?";
		PreparedStatement preState = conn.prepareStatement(sqlStr);
		preState.setInt(1,id);
		ResultSet rs = preState.executeQuery();
		
		Member m = null;//放這裡是因為如果放if裡，做完Member findById(int id)就讀不到了
		
		if(rs.next()) {
			m = new Member();
			m.setMemberId(rs.getInt("id"));//這筆資料，表格欄位名稱 id內的資料
			m.setMemberName(rs.getString("name"));
			m.setPhone(rs.getString("address"));
			m.setPhone(rs.getString("phone"));
		}
		
		rs.close();
		preState.close();
		return m;
	}
	
	
	//刪除資料方法,用 id
	public void deleteMemberById(int id) throws SQLException {
		String sqlStr = "Delete From member where id = ?";
		PreparedStatement preState = conn.prepareStatement(sqlStr);
		preState.setInt(1, id);
		preState.execute();
		preState.close();
	}
}
