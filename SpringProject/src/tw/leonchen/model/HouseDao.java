package tw.leonchen.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("houseDao")
public class HouseDao {

	@Autowired @Qualifier("sqlserverDataSource")
	private DataSource dataSource;
	
	public House select(int houseid) throws SQLException {
		House hBean = null;
		Connection conn = dataSource.getConnection();
		
		String sqlStr = "select * from House where houseid=?";
		PreparedStatement preState = conn.prepareStatement(sqlStr);
		preState.setInt(1, houseid);
		ResultSet rs = preState.executeQuery();
		
		if(rs.next()) {
			hBean = new House();
			hBean.setHouseid(rs.getInt(1));
			hBean.setHousename(rs.getString(2));
		}
		
		rs.close();
		preState.close();
		conn.close();
		
		return hBean;
	}
}
