package ch06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch06.model.Employee;

public class HibernateQueryExercise05 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "FROM Employee e WHERE e.salary >= :sal ORDER BY e.salary ASC, e.id ASC";
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();	
		
		   List<Employee> emps = session.createQuery(hql)
				   						.setParameter("sal", 29000)
				   					    .getResultList();
		   for(Employee e : emps) {
			   System.out.println(e);
		   }
		   tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}
