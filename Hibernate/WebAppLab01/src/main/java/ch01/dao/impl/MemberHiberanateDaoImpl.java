package ch01.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _init.HibernateUtils;
import ch01.dao.MemberDao;
import ch01.model.MemberBean;

//實作介面或繼承父類別,程式使用時直接寫父類別/介面名稱
public class MemberHiberanateDaoImpl implements MemberDao  {
//	String resource = "java:comp/env/jdbc/memberDB";

	private static Logger log = LoggerFactory.getLogger(MemberHiberanateDaoImpl.class);
	
	SessionFactory factory;
	
	public MemberHiberanateDaoImpl() {
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public boolean isDup(String sid) {
		boolean result = false;
		String hql = "FROM MemberBean m WHERE m.id = :pid";	//hql:hibernate query language
		Session session = factory.getCurrentSession();
		
		List<MemberBean> list = session.createQuery(hql,MemberBean.class)
										.setParameter("pid",sid)
										.getResultList();
		if(list.size() > 0) {
			result = true;
		}
		
		 log.info("isDup(), sid="+sid+",result="+result);
		
		return result;
	}

	@Override
	public int save(MemberBean mb) {
		int count = 0;
		Session session =factory.getCurrentSession();
		session.save(mb);
		count++;
		
		log.info("save(), mb="+mb+", count="+count);
		
		return count;
	}

	@Override
	public List<MemberBean> getAllMembers() {
		String hql = "FROM MemberBean m";	//hql:hibernate query language
		Session session = factory.getCurrentSession();
		
		List<MemberBean> list = session.createQuery(hql,MemberBean.class)
										.getResultList();
		
		log.info("getAllMembers(), list="+list);
		
		return list;
	}

	@Override
	public MemberBean getMember(int pk) {
		MemberBean mb = null;
		Session session =factory.getCurrentSession();
//		mb = session.get(MemberBean.class, pk);
		
		mb = session.load(MemberBean.class, pk);
		Hibernate.initialize(mb);
				
//		log.info("getMember(), mb="+mb);
		
		return mb;
	}

	@Override
	public int deleteMember(int pk) {
		
		int count = 0;
		Session session =factory.getCurrentSession();
		MemberBean mb = new MemberBean(pk);
		session.delete(mb);
		count++;
		
		log.info("deleteMember(),pk="+pk+", count="+count);
		
		return count;
	}

	@Override
	public int updateMember(MemberBean mb) {
		int count = 0;
		Session session =factory.getCurrentSession();
		session.save(mb);
		count++;
		
		log.info("deleteMember(),mb="+mb+", count="+count);
		
		return count;
	}
}
