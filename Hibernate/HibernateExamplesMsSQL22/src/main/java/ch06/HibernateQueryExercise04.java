package ch06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch06.model.Employee;

public class HibernateQueryExercise04 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "SELECT e.salary, e.name, e.birthday FROM Employee e";
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();	
		
		   List<Object[]> list = session.createQuery(hql)
				   					   .getResultList();
		   for(Object[] oa : list) {
			   System.out.println(oa[0] + ", " + oa[1] + ", " + oa[2]);
		   }
		   tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}
