package ch04._00.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch04._00.dao.MemberDao;
import ch04.ex01.model.HibernateUtils;
import ch04.ex01.model.Member;

public class MemberDaoImpl_Hibernate_Only implements MemberDao {
	
	SessionFactory factory = HibernateUtils.getSessionFactory();
	// Checked, OK
	public boolean idExists(String id) {
		boolean exist = false;
		String hql = "FROM Member WHERE userId = :uid";
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Member member = null;
			try {
				member = (Member) session.createQuery(hql)
						.setParameter("uid", id)
						.getSingleResult();
			} catch(NoResultException | NonUniqueResultException e){
				;
			}
			if (member != null) { 
				exist = true;
			}
			tx.commit();
		} catch(Exception e){
			if (tx!=null) tx.rollback();
			throw new RuntimeException(e);
		} 
		return exist;
	}
	// 新增一筆Member物件到資料庫
	public Object saveMember(Member mem){
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(mem);
			tx.commit();
		} catch(Exception e){
			if (tx!=null) tx.rollback();
			throw new RuntimeException(e.getMessage(), e);
		} 
		return mem;
	}

	// 經由Session介面的get()查詢資料庫內的紀錄
	public Member getMember(int pk) {
		Member member = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			member = session.get(Member.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			throw new RuntimeException(e);
		}
		return member;
	}
	// 更新紀錄
	public void updateMember(Member mem)  {
		Member member = null;
		Session session = factory.getCurrentSession();
		Transaction tx =null;
		try {
			tx = session.beginTransaction();
//			// 更新方法   
            member = (Member)session.get(Member.class, mem.getPk()); // member: Persistent
			member.setEmail(mem.getEmail());
			member.setExperience(mem.getExperience());
			member.setName(mem.getName());
			member.setTel(mem.getTel());
		    //session.update(member);
			// 更新方法二
//			session.merge(mem);        // mem為Transient物件
			// 只做新增
			//session.save(mem);
			// 更新方法三			
//			session.saveOrUpdate("Member", mem);  // mem為Transient物件
			tx.commit();
		} catch(Exception e){
			if (tx != null) tx.rollback();
			throw new RuntimeException(e);
		}
		return;
	}
	// 刪除紀錄
	public void deleteMember(int pk)  {
		Session session = factory.getCurrentSession();
		Transaction tx =null;
		try {
			tx = session.beginTransaction();
			Member mem = new Member(pk);
			session.delete(mem);   
			tx.commit();
		
		} catch(Exception e){
			if (tx != null) tx.rollback();
			throw new RuntimeException("刪除紀錄時發生異常", e);
		}
		return;
	}
	// 查詢所有紀錄	。Checked, OK
	@SuppressWarnings("unchecked")
	public List<Member> getAllMembers()  {
		String hql = "FROM Member"; 
		List<Member> allMembers = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			allMembers = session.createQuery(hql).getResultList();
			tx.commit();
		} catch(Exception e){
			if ( tx != null ) tx.rollback();
			throw new RuntimeException(e);
		} 
		return allMembers;
	}
	
	@Override
	public void close() {
		factory.close();
	}
	@Override
	public Member loadMember(int pk) {
		Member member = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			member = session.load(Member.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			throw new RuntimeException(e);
		}
		return member;
	}	
}
