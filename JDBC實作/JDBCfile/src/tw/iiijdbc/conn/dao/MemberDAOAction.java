package tw.iiijdbc.conn.dao;

import java.nio.channels.NonWritableChannelException;
import java.sql.SQLException;

public class MemberDAOAction {

	public static void main(String[] args) throws SQLException {
		
		MemberDAO mDAO = MemberDAOFactory.createMemberDAO();
		
		mDAO.createConn();

/*
		//加入 2 會員
		Member m1 = new Member();
		m1.setMemberId(1001);
		m1.setMemberName("Tony");
		m1.setMemberAddress("Japan");
		m1.setPhone("NO");
		mDAO.addMember(m1);
		
		Member m2 = new Member();
		m2.setMemberId(1002);
		m2.setMemberName("Gina");
		m2.setMemberAddress("USA");
		m2.setPhone("3345678");
		mDAO.addMember(m2);
*/
		
		//根據 ID 刪除
		mDAO.deleteMemberById(1002);
		
		
		//修改
		Member m3 = new Member();
		m3.setMemberId(1001);
		m3.setMemberName("Tony");
		m3.setMemberAddress("South Korea");
		m3.setPhone("1234567890");
		mDAO.updateByIdAndName(m3);

		
		//用 ID 找一筆資料
		Member m4 = mDAO.findById(1001);
		System.out.println("getMemberId: " + m4.getMemberId());
		System.out.println("getMemberName: " + m4.getMemberName());
		System.out.println("getPhone: " + m4.getPhone());
		System.out.println("getMemberAddress: " + m4.getMemberAddress());
		
		mDAO.closeConn();
	}

}
