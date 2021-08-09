package ch05.many2one._01.anno.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.many2one._01.anno.model.Employer;
import ch05.many2one._01.anno.util.HibernateUtils;


public class EmployerDAO {
	public void save(Employer emper) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.save(emper);
			tx.commit();
		} catch(Exception e){
			System.out.println(e);
			if (tx != null) 
				tx.rollback();
		} finally{
			if (session != null)
			session.close();
		}
	}
	public Employer findByPrimaryKey(long key) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employer emper = null;
		try{
			emper = session.get(Employer.class, key);
			tx.commit();
			
		} catch(Exception ex){
			System.out.println(ex);
			if (tx != null) 
				tx.rollback();
		} finally{
			if (session != null)
			session.close();
		}
		return emper;
	}
	
	
	
	public int deleteByPrimaryKey(int key) {
		int count = 0 ;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employer emper = new Employer();
		emper.setId(key);
		try{
			session.delete(emper);
			count++;
			tx.commit();
			
		} catch(Exception ex){
			System.out.println(ex);
			if (tx != null) 
				tx.rollback();
		} finally{
			if (session != null)
			session.close();
		}
		return count;
	}
	
	
}
