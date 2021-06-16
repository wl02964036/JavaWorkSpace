package tw.iiijdbc.conn.day3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tw.iiijdbc.util.DbConnUtil;

public class Demo11Transaction {

	public static void main(String[] args) throws SQLException {
		
		DbConnUtil util = new DbConnUtil();
		
		Connection conn = null;
		
		try {
//			Connection conn = util.createSQLServerConn();
			 conn = util.createSQLServerConn();
			conn.setAutoCommit(false);//轉為隱含交易
			
			String sqlStr = "Update product set remark = ? where productid = ?";
			PreparedStatement preState = conn.prepareStatement(sqlStr);
			
			preState.setString(1, "因疫情關係，不在 24Hr 保障內");
			preState.setInt(2, 1003);
			preState.execute();
			
			preState.setString(1, "因疫情關係，不在 24Hr 保障內");
			preState.setInt(2, 1004);
			preState.execute();
			
			conn.commit();
			System.out.println("Commit OK!!");
			conn.setAutoCommit(true);//轉回Auto Commit模式
			
			preState.close();
			
		} catch (SQLException e) {
			System.out.println("SomeThing Wrong and ROLLBACK");
			conn.rollback();
			e.printStackTrace();
		}finally {
			conn.close();
			System.out.println("Connection Close!! ");
		}
		
		
	}

}
