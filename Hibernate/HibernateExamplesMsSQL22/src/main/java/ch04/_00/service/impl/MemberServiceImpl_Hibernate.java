package ch04._00.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch04._00.dao.MemberDao;
import ch04._00.dao.impl.MemberDaoImpl_Hibernate;
import ch04._00.service.MemberService;
import ch04.ex01.model.HibernateUtils;
import ch04.ex01.model.Member;

public class MemberServiceImpl_Hibernate implements MemberService {
	MemberDao dao;
	SessionFactory factory;

	public MemberServiceImpl_Hibernate() {
		dao = new MemberDaoImpl_Hibernate();
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public Object saveMember(Member mem) {
		Object obj = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			obj = dao.saveMember(mem);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
		return obj;
	}

	@Override
	public Member getMember(int id) {
		Member m = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			m = dao.getMember(id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
		return m;

	}

	@Override
	public boolean idExists(String id) {
		boolean exist = false;

		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			exist = dao.idExists(id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
		return exist;
	}

	@Override
	public void updateMember(Member mem) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.updateMember(mem);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteMember(int pk) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.deleteMember(pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Member loadMember(int pk) {
		Member member = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			member = dao.loadMember(pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
		return member;
	}

	@Override
	public List<Member> getAllMembers() {
		List<Member> members = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			members = dao.getAllMembers();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
		return members;
	}

	@Override
	public void close() {
		dao.close();
	}

}
