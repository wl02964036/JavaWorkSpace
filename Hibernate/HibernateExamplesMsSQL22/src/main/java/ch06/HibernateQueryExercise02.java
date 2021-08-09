package ch06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch06.model.Employee;

public class HibernateQueryExercise02 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "SELECT e.name FROM Employee e";
		Object obj = new Object();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();	
		
		   List<String> names = session.createQuery(hql)
				   					   .getResultList();
		   for(String name : names) {
			   System.out.println(name);
		   }
		   tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}
