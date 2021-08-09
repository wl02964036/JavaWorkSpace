
//DAO: Database Access Object

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import mvcdemo.bean.HealthBean;

public class HealthDAO {

//	private Connection conn;

////建構子
//	public HealthDAO(Connection conn) {
//		this.conn = conn;
//	}

	private DataSource dataSource;

	public HealthDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private Connection conn;

//
////開連線
//public void createConn() throws SQLException{
//
//	try {
//		conn = dataSource.getConnection();		
//		System.out.println("Connection Open status: " + !conn.isClosed());
//	} catch (SQLException e) {
//
//		e.printStackTrace();
//	}
//}

//關連線
	public void closeConn() {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("Fail to Close Connection to DataBase!");
				System.out.println("Please see detail information:");
				e.printStackTrace();
			}
			System.out.println("Close connection!");

		}
	}

//新增資料
	public boolean insertHealth(HealthBean studentData) throws SQLException {
		Connection conn = null;
		Statement stmt = null;

		try {

			conn = dataSource.getConnection();
			String sqlString = "insert into comp values('" + studentData.getEmpno() + "','" + studentData.getEname()
					+ "','" + studentData.getGender() + "','" + studentData.getRocid1() + "','" + studentData.getYear1()
					+ "','" + studentData.getMonth1() + "','" + studentData.getDay1() + "','" + studentData.getCname1()
					+ "','" + studentData.getAccount1() + "','" + studentData.getPwd1() + "','" + studentData.getPwd2()
					+ "','" + studentData.getEmail1() + "','" + studentData.getPhone1() + "','"
					+ studentData.getPhone2() + "','" + studentData.getAddr1() + "','" + studentData.getAddr2() + "','"
					+ studentData.getAddr3() + "')";
			System.out.println(studentData.getEmpno());
			System.out.println(sqlString);
			stmt = conn.createStatement();
			int updatecount = stmt.executeUpdate(sqlString);
			stmt.close();
			if (updatecount >= 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		} finally {
			conn.close();
		}
	}

///查詢全部資料
	public ArrayList<HealthBean> searchAllHealth() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<HealthBean> arrayHealth = new ArrayList<HealthBean>();
		String sqlString = "select * from comp order by empno";

		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();

			System.out.println(sqlString);
			ResultSet rs = stmt.executeQuery(sqlString);

			while (rs.next()) {
				HealthBean meg1 = new HealthBean();
				meg1.setEmpno(rs.getString("empno"));
				meg1.setEname(rs.getString("ename"));
				meg1.setGender(rs.getString("gender"));
				meg1.setRocid1(rs.getString("rocid"));
				meg1.setYear1(rs.getString("year1"));
				meg1.setMonth1(rs.getString("month1"));
				meg1.setDay1(rs.getString("day1"));
				meg1.setCname1(rs.getString("cname1"));
				meg1.setAccount1(rs.getString("account1"));
				meg1.setPwd1(rs.getString("pwd1"));
				meg1.setPwd2(rs.getString("pwd2"));
				meg1.setEmail1(rs.getString("email1"));
				meg1.setPhone1(rs.getString("phone1"));
				meg1.setPhone2(rs.getString("phone2"));
				meg1.setAddr1(rs.getString("addr1"));
				meg1.setAddr2(rs.getString("addr2"));
				meg1.setAddr3(rs.getString("addr3"));

				arrayHealth.add(meg1);

			}
		} catch (Exception e) {
			System.err.println("查詢全部資料時發生錯誤:" + e);
		} finally {
			closeConn();
		}
		return arrayHealth;
	}

//查詢單筆資料
	public ArrayList<HealthBean> searchHealthByNo(String empno) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ArrayList<HealthBean> arrayHealth = new ArrayList<HealthBean>();
		String sqlString = "select * from comp where empno=?";
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sqlString);
			System.out.println(sqlString);
			stmt.setString(1, empno);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				HealthBean meg1 = new HealthBean();
				meg1.setEmpno(rs.getString("empno"));
				meg1.setEname(rs.getString("ename"));
				meg1.setGender(rs.getString("gender"));
				meg1.setRocid1(rs.getString("rocid"));
				meg1.setYear1(rs.getString("year1"));
				meg1.setMonth1(rs.getString("month1"));
				meg1.setDay1(rs.getString("day1"));
				meg1.setCname1(rs.getString("cname1"));
				meg1.setAccount1(rs.getString("account1"));
				meg1.setPwd1(rs.getString("pwd1"));
				meg1.setPwd2(rs.getString("pwd2"));
				meg1.setEmail1(rs.getString("email1"));
				meg1.setPhone1(rs.getString("phone1"));
				meg1.setPhone2(rs.getString("phone2"));
				meg1.setAddr1(rs.getString("addr1"));
				meg1.setAddr2(rs.getString("addr2"));
				meg1.setAddr3(rs.getString("addr3"));

				arrayHealth.add(meg1);

			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			System.err.println("查詢單筆資料時發生錯誤:" + e);
		} finally {
			conn.close();
		}
		return arrayHealth;

	}

//刪除單筆資料
	public boolean deleteHealth(String empno) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean torf = false;
		String sqlString = "delete from comp where empno=?";
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sqlString);
			System.out.println(sqlString);
			System.out.println(empno);
			stmt.setString(1, empno);
			torf = stmt.execute();
			System.out.println(stmt);
			
		} catch (Exception e) {
			System.err.println("刪除單筆資料時發生錯誤:" + e);
		} finally {
			conn.close();
		}
		return torf;
	}
	
	//修改單筆資料
		public boolean updateHealth(HealthBean updateHealthBean) throws SQLException {
			Connection conn = null;
			PreparedStatement stmt = null;
			String sqlString = "update comp set ename =?, gender=?, rocid=?, year1=?, month1=?, day1=?, cname1=?, account1=?, pwd1=?, pwd2=?, email1=?, phone1=?, phone2=?, addr1=?, addr2=?, addr3=?"
					+ " where empno=?";

			try {
				conn = dataSource.getConnection();
				stmt = conn.prepareStatement(sqlString);
				System.out.println(sqlString);
				stmt.setString(1, updateHealthBean.getEname());
				stmt.setString(2, updateHealthBean.getGender());
				stmt.setString(3, updateHealthBean.getRocid1());
				stmt.setString(4, updateHealthBean.getYear1());
				stmt.setString(5, updateHealthBean.getMonth1());
				stmt.setString(6, updateHealthBean.getDay1());
				stmt.setString(7, updateHealthBean.getCname1());
				stmt.setString(8, updateHealthBean.getAccount1());
				stmt.setString(9, updateHealthBean.getPwd1());
				stmt.setString(10, updateHealthBean.getPwd2());
				stmt.setString(11, updateHealthBean.getEmail1());
				stmt.setString(12, updateHealthBean.getPhone1());
				stmt.setString(13, updateHealthBean.getPhone2());
				stmt.setString(14, updateHealthBean.getAddr1());
				stmt.setString(15, updateHealthBean.getAddr2());
				stmt.setString(16, updateHealthBean.getAddr3());
				stmt.setString(17, updateHealthBean.getEmpno());

				int updatecount = stmt.executeUpdate();
				stmt.close();
				if (updatecount >= 1)
					return true;
				else
					return false;
			} catch (Exception e) {
				System.err.println("修改單筆資料時發生錯誤:" + e);
			} finally {
				conn.close();
			}
			return false;
		}
		
		//登陸後查詢資料
		public List<HealthBean> searchHealthByAP() throws SQLException {
			Connection conn = null;
			PreparedStatement stmt = null;
			List<HealthBean> arrayHealth = new ArrayList<HealthBean>();
			String sqlString = "select account1,pwd1 from comp";
			try {
				conn = dataSource.getConnection();
				stmt = conn.prepareStatement(sqlString);
				System.out.println(sqlString);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					HealthBean meg1 = new HealthBean();
					meg1.setAccount1(rs.getString("account1"));
					meg1.setPwd1(rs.getString("pwd1"));


					arrayHealth.add(meg1);

				}
				rs.close();
				stmt.close();

			} catch (Exception e) {
				System.err.println("查詢單筆資料時發生錯誤:" + e);
			} finally {
				conn.close();
			}
			return arrayHealth;

		}

}