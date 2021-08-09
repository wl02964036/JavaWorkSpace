package ch01.service;

import java.util.List;

import ch01.model.MemberBean;

public interface MemberService {

	boolean isDup(String id);

	int save(MemberBean mb);

	List<MemberBean> getAllMembers();

	MemberBean getMember(int pk);

	int deleteMember(int ipk);

	int updateMember(MemberBean mb);

}