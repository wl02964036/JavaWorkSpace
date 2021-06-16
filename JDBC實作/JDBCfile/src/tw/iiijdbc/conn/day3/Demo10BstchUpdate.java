package tw.iiijdbc.conn.day3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import tw.iiijdbc.util.DbConnUtil;

public class Demo10BstchUpdate {

	public void PasswordGenerateBatch() throws SQLException {
		ArrayList<String> users = new ArrayList<>();
		users.add("Tom");
		users.add("Gina");
		users.add("Mary");
		users.add("Mike");
		
		DbConnUtil util = new DbConnUtil();
		
		Connection conn = util.createSQLServerConn();
		
		String sqlStr = "Insert into Users(username,userPwd) Values(?,?)";
		PreparedStatement preState = conn.prepareStatement(sqlStr);
		
		for(String aUser:users) {
			preState.setString(1, aUser);
			preState.setString(2, "qpoev" + (int)(Math.random()*10000000) +1+"kjnkj");
			//Math.random強轉成int是要整數，+1是不想要0，*10000000是要有10000000種結果
			preState.addBatch();//隱含的List
			
		}
		
		//我想知道更新幾筆資料
		int[] rows = preState.executeBatch();//因為要查找ArrayList的資料，所以用int[]
		System.out.println(" sql counts: " +rows.length);
		preState.close();
		util.closeConn();
	}
	
	
	
	
	public static void main(String[] args) {
		
		Demo10BstchUpdate demo10 = new Demo10BstchUpdate();
		
		try {
			demo10.PasswordGenerateBatch();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("e.getMessage(): " + e.getMessage());
		}
	}

}
