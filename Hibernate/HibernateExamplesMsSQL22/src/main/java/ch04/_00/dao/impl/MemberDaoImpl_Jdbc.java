package ch04._00.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ch04._00.dao.MemberDao;
import ch04.ex01.model.Member;
import ch04.ude.RecordNotFoundException;
// JDBC版
public class MemberDaoImpl_Jdbc implements MemberDao {
	Context ctx;

	public MemberDaoImpl_Jdbc() {
		try {
			ctx = new InitialContext();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean idExists(String memberId) {
		boolean exist = false;
		String sql = "SELECT * FROM MemberExample WHERE account = ?";
		try {
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MemberDataBase");
			try (
				Connection conn = ds.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql);
			) {
				stmt.setString(1, memberId);
				try (ResultSet rs = stmt.executeQuery();) {
					if (rs.next()) {
						exist = true;
					}
				}
			}
		} catch (Exception e) {
			throw new RecordNotFoundException(e);
		}
		return exist;
	}

	// 新增一筆Member紀錄
	public Object saveMember(Member mem) {
		String sql = "INSERT INTO MemberExample " + "(account, password, name, email, tel, experience) "
				+ " VALUES( ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try {
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MemberDataBase");
			try (
				Connection conn = ds.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql);
			) {
				stmt.setString(1, mem.getMemberId());
				stmt.setString(2, mem.getPassword());
				stmt.setString(3, mem.getName());
				stmt.setString(4, mem.getEmail());
				stmt.setString(5, mem.getTel());
				stmt.setInt(6, mem.getExperience());
				n = stmt.executeUpdate();
			}
		} catch (Exception e) {
			throw new RecordNotFoundException(e);
		}
		return n;
	}

	// 查詢一筆Member紀錄.
	public Member getMember(int pk) {
		Member member = null;
		String sql = "SELECT * FROM MemberExample WHERE pk = ?";
		try {
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MemberDataBase");
			try (
				Connection conn = ds.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql);
			) {
				stmt.setInt(1, pk);
				try (ResultSet rset = stmt.executeQuery();) {
					if (rset.next()) {
						member = new Member(rset.getInt("pk"), rset.getString("account"), rset.getString("password"),
								rset.getString("name"), rset.getString("email"), rset.getString("tel"),
								rset.getInt("experience"));
					}
				}
			}
		} catch (Exception e) {
			throw new RecordNotFoundException(e);
		}

		return member;
	}

	// 更新一筆Member紀錄
	public void updateMember(Member mem) {

		String sql = "UPDATE MemberExample SET account=?, password=?, name=?, email=?, tel=?, experience=? where pk = ?";
		try {
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MemberDataBase");
			try (
				Connection conn = ds.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql);
			) {
				stmt.setString(1, mem.getMemberId());
				stmt.setString(2, mem.getPassword());
				stmt.setString(3, mem.getName());
				stmt.setString(4, mem.getEmail());
				stmt.setString(5, mem.getTel());
				stmt.setInt(6, mem.getExperience());
				stmt.setInt(7, mem.getPk());
				int count = stmt.executeUpdate();
				if (count == 0) {
					throw new RecordNotFoundException("無法更新紀錄或該筆紀錄不存在");
				}
			}
		} catch (Exception e) {
			throw new RecordNotFoundException(e);
		}
		return;
	}

	// 刪除一筆Member紀錄
	public void deleteMember(int pk) {
		String sql = "DELETE FROM MemberExample WHERE pk = ?";
		try {
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MemberDataBase");
			try (
				Connection conn = ds.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql);
			) {
				stmt.setInt(1, pk);
				int count = stmt.executeUpdate();
				
				if (count == 0) {
					throw new RecordNotFoundException("無法刪除紀錄或該筆紀錄不存在");
				}
			}
		} catch (Exception e) {
			throw new RecordNotFoundException(e);
		}
		return;
	}

	// 查詢多筆Member紀錄
	public List<Member> getAllMembers() {
		List<Member> allMembers = new ArrayList<Member>();
		String sql = "SELECT * FROM  MemberExample";
		try {
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MemberDataBase");
			try (
				Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
			) {
				Member mem = null;
				while (rs.next()) {
					mem = new Member(rs.getInt("pk"), rs.getString("account"), 
							rs.getString("password"), rs.getString("name"), rs.getString("email"),
							rs.getString("tel"), rs.getInt("experience"));
					System.out.println("0530: " + mem);
					allMembers.add(mem);
				}
			}
		} catch (Exception e) {
			throw new RecordNotFoundException(e);
		}
		return allMembers;
	}

	@Override
	public void close() {
		try {
			ctx.close();
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Member loadMember(int pk) {
		return getMember(pk) ;
	}
}
