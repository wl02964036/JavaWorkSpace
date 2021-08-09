//package ch01.service.impl;
//
//import java.util.List;
//
//import ch01.dao.MemberDao;
//import ch01.dao.impl.MemberJdbcDaoImpl;
//import ch01.model.MemberBean;
//import ch01.service.MemberService;
//
//public class MemberServiceImpl implements MemberService {
//
//	@Override
//	public boolean isDup(String id) {
//		MemberDao dao = new MemberJdbcDaoImpl();
//		return dao.isDup(id);
//	}
//
//	@Override
//	public int save(MemberBean mb) {
//		MemberDao dao = new MemberJdbcDaoImpl();
//		return dao.save(mb);
//	}
//
//	@Override
//	public List<MemberBean> getAllMembers() {
//		MemberDao dao = new MemberJdbcDaoImpl();
//		return dao.getAllMembers();
//	}
//
//	@Override
//	public MemberBean getMember(int pk) {
//		MemberDao dao = new MemberJdbcDaoImpl();
//		return dao.getMember(pk);
//	}
//
//	@Override
//	public int deleteMember(int ipk) {
//		MemberDao dao = new MemberJdbcDaoImpl();
//		return dao.deleteMember(ipk);
//	}
//
//	@Override
//	public int updateMember(MemberBean mb) {
//		MemberDao dao = new MemberJdbcDaoImpl();
//		return dao.updateMember(mb);
//	}
//
//}
