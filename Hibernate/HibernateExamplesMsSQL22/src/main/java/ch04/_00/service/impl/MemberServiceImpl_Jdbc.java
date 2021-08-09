package ch04._00.service.impl;

import java.util.List;

import ch04._00.dao.MemberDao;
import ch04._00.dao.impl.MemberDaoImpl_Jdbc;
import ch04._00.service.MemberService;
import ch04.ex01.model.Member;

public class MemberServiceImpl_Jdbc implements MemberService {
    MemberDao dao;
	public MemberServiceImpl_Jdbc() {
		dao = new MemberDaoImpl_Jdbc();
	}

	@Override
	public Object saveMember(Member mem) {
		return dao.saveMember(mem);
	}

	@Override
	public Member getMember(int id) {
		return dao.getMember(id);
	}

	@Override
	public boolean idExists(String id) {
		return dao.idExists(id);
	}

	@Override
	public void updateMember(Member mem) {
		 dao.updateMember(mem);
	}

	@Override
	public void deleteMember(int pk) {
		 dao.deleteMember(pk);
	}

	@Override
	public Member loadMember(int pk) {
		return dao.loadMember(pk);
	}

	@Override
	public List<Member> getAllMembers() {
		return dao.getAllMembers();
	}

	@Override
	public void close() {
		dao.close();
	}

}
