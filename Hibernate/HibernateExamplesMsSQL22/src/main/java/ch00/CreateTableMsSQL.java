package ch00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTableMsSQL {
	 
	public static void main(String[] args) throws SQLException {
		String sql = "IF OBJECT_ID('dbo.MemberExample', 'U') IS NOT NULL DROP TABLE dbo.MemberExample;";
		String sql1 = "CREATE TABLE MemberExample"
				+ "( PK INTEGER IDENTITY NOT NULL, "
				+ " account VARCHAR(32), "
				+ " password VARCHAR(32), "
				+ " name VARCHAR(32), "
				+ " email VARCHAR(64), "
				+ " tel VARCHAR(20), "
				+ " experience INTEGER, "
				+ " PRIMARY KEY(PK) , "
				+ ") ;";
		Connection con =  DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DATABASENAME=jspdb"
					, SystemConstant.user
					, SystemConstant.password);
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.executeUpdate();
        PreparedStatement stmt1 = con.prepareStatement(sql1);
        stmt1.executeUpdate();
        System.out.println("表格新增成功");
	}

}
