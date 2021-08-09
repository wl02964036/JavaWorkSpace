package ch04._00.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Hibernate;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ch04._00.dao.MemberDao;
import ch04.ex01.model.HibernateUtils;
import ch04.ex01.model.Member;
import ch04.ude.RecordNotFoundException;

public class MemberDaoImpl_Hibernate implements MemberDao {
	
	SessionFactory factory = HibernateUtils.getSessionFactory();

	public boolean idExists(String id) {
		boolean exist = false;
		String hql = "FROM Member WHERE userId = :uid";
		Session session = factory.getCurrentSession();
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
		return exist;
	}
	// 新增一筆Member物件到資料庫
	public Object saveMember(Member mem){
		Session session = factory.getCurrentSession();
		session.save(mem);
		return mem;
	}
	//
	// 經由Session介面的load()查詢資料庫內的紀錄
	public Member loadMember(int pk)  {
		Member member = null;
		Session session = factory.getCurrentSession();
		Integer ipk = Integer.valueOf(pk);
		member = session.load(Member.class, ipk);
		// org.hibernate.LazyInitializationException: could not initialize proxy [ch04.ex01.model.Member#20] - no Session
		// 提早塞資料，如果刪除此敘述會丟出上面的例外  
		Hibernate.initialize(member);   
		return member;
	}
	// 經由Session介面的get()查詢資料庫內的紀錄
	public Member getMember(int pk) {
		Member member = null;
		Session session = factory.getCurrentSession();
		Integer ipk = Integer.valueOf(pk);
		member = session.get(Member.class, ipk);
		return member;
	}
	// 更新方法一   
	public void updateMember(Member mem)  {
		Member member = null;
		Session session = factory.getCurrentSession();
		// member為永續物件
        member = (Member)session.get(Member.class, mem.getPk()); 
		member.setEmail(mem.getEmail());
		member.setExperience(mem.getExperience());
		member.setName(mem.getName());
		member.setTel(mem.getTel());
	}
	// 更新方法二
	public void updateMember2(Member mem)  {
		Session session = factory.getCurrentSession();
		session.merge(mem);        // mem為Transient物件
	}
	// 更新方法三			
	public void updateMember3(Member mem)  {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate("Member", mem);  // mem為Transient物件
	}
	// 刪除紀錄
	public void deleteMember(int pk)  {
		Session session = factory.getCurrentSession();
		try {
			Member mem = new Member(pk);
			session.delete(mem);   
		} catch(Exception e){
			String classname5 =  e.getCause().getClass().getName();
			String classname4 =  e.getClass().getName();
			if ( classname5.equalsIgnoreCase("org.hibernate.StaleStateException") || 
				classname4.equalsIgnoreCase("org.hibernate.StaleStateException")	
			) {
				throw new RecordNotFoundException("要刪除的紀錄不存在: 主鍵值為: " + pk);
			} else {
				throw new RecordNotFoundException("刪除紀錄時發生異常", e);
			}
		}
		return;
	}
	// 查詢所有紀錄
	@SuppressWarnings("unchecked")
	public List<Member> getAllMembers()  {
		String hql = "FROM Member"; 
		List<Member> allMembers = null;
		Session session = factory.getCurrentSession();
		allMembers = session.createQuery(hql).getResultList();
		return allMembers;
	}
	
	@Override
	public void close() {
		factory.close();
	}	
}
