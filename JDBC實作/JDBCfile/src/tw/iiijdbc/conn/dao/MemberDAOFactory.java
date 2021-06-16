package tw.iiijdbc.conn.dao;

public class MemberDAOFactory {

	public static MemberDAO createMemberDAO() {
		MemberDAO mDAO = new MemberDAO();
		return mDAO;

	}

}
