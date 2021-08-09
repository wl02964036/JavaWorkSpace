package ch05.many2one._01.anno.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ch05.many2one._01.anno.model.Employee;
import ch05.many2one._01.anno.util.HibernateUtils;


public class EmployeeDAO {
	public void save(Employee emp) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.save(emp);
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
	public Employee findByPrimaryKey(Integer key) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee emp = null;
		try{
			emp = session.get(Employee.class, key);
			tx.commit();
			
		} catch(Exception ex){
			System.out.println(ex);
			if (tx != null) 
				tx.rollback();
		} finally{
			if (session != null)
			session.close();
		}
		return emp;
	}
	public int deleteByPrimaryKey(int key) {
		int count = 0 ;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			Employee emp = new Employee();
			emp.setId(key);
			session.delete(emp);
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
	
	
	public int findEmployeeAmount(int fKey) {
		int count = 0 ;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			String hql = "FROM Employee e WHERE e.employer.id= :key";
			Query query = session.createQuery(hql).setParameter("key", fKey);
			List<Employee> emps = query.getResultList();
			if (emps != null) {
				count = emps.size();
			}
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
