package ch04._00.dao;

import java.util.List;

import ch04.ex01.model.Member;

public interface MemberDao {
	public Object saveMember(Member mem);

	public Member getMember(int id);
	
	public Member loadMember(int id);

	public boolean idExists(String id);

	public void updateMember(Member mem);

	public void deleteMember(int pk);

	public List<Member> getAllMembers();

	public void close();
}
