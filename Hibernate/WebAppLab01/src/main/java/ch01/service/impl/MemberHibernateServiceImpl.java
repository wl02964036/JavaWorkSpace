package ch01.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import _init.HibernateUtils;
import ch01.dao.MemberDao;
import ch01.dao.impl.MemberHiberanateDaoImpl;
import ch01.model.MemberBean;
import ch01.service.MemberService;

public class MemberHibernateServiceImpl implements MemberService {

	
	SessionFactory factory;
	MemberDao memberDao;
	

	
	
	public MemberHibernateServiceImpl() {
		this.factory = HibernateUtils.getSessionFactory();
		this.memberDao = new MemberHiberanateDaoImpl();
	}

	@Override
	public boolean isDup(String id) {	//isDup是service，由controller呼叫
		Boolean result = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			result = memberDao.isDup(id);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	@Override
	public int save(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			count = memberDao.save(mb);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return count;
	}

	@Override
	public List<MemberBean> getAllMembers() {
		List<MemberBean> beans = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			beans = memberDao.getAllMembers();
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return beans;
	}

	@Override
	public MemberBean getMember(int pk) {
		MemberBean bean = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			bean= memberDao.getMember(pk);
//			tx.commit();
//		} catch (Exception e) {
//			if(tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
		return bean;
	}

	@Override
	public int deleteMember(int ipk) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			count = memberDao.deleteMember(ipk);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return count;
	}

	@Override
	public int updateMember(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			count = memberDao.updateMember(mb);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return count;
	}

}
