package ch04._00.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ch04._00.dao.MemberDao;
import ch04.ex01.model.HibernateUtils;
import ch04.ex01.model.Member;

public class MemberDaoImpl_WithLazyLoadingFilter implements MemberDao {
	private SessionFactory factory = HibernateUtils.getSessionFactory();
	
	public MemberDaoImpl_WithLazyLoadingFilter() {
	}

	public void setSessionFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	public boolean idExists(String memberId) {
		boolean exist = false;
		String hql = "FROM Member WHERE memberId = :uid";
		Session session = factory.getCurrentSession();
		List<Member> list = session.createQuery(hql)
								   .setParameter("uid", memberId)
				                   .getResultList();
		if (list.size() > 0) { 
			exist = true;
		}
		return exist;
	}

	public Object saveMember(Member mem) {
		Session session = factory.getCurrentSession();
		try {
			session.persist(mem);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
		
		return mem;
	}

	public Member getMember(int pk) {
		Member member = null;
		Session session = factory.getCurrentSession();
		member = session.get(Member.class, pk);
		return member;
	}

	public void updateMember(Member mem) {
		Session session = factory.getCurrentSession();
		try {
			session.saveOrUpdate("Member", mem); // mem為Transient物件
		} catch(Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	public void deleteMember(int pk) {
		Session session = factory.getCurrentSession();
		Member mem = new Member(pk);
		try {
			session.delete(mem);
		} catch(Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Member> getAllMembers() {
		List<Member> allMembers = new ArrayList<Member>();
		Session session = factory.getCurrentSession();
		allMembers = session.createQuery("From Member").getResultList();
		return allMembers;
	}


	@Override
	public void close() {
		factory.close();
	}

	@Override
	public Member loadMember(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
