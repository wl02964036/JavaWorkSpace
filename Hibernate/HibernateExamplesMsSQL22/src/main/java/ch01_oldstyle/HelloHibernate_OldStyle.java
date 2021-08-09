package ch01_oldstyle;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HelloHibernate_OldStyle  {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setName("張君雅");
		emp.setEmployeeId("A025");
		emp.setEmail("mary3597@gmail.com");
		emp.setDepId("ITA");

		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(emp);
			emp.setName("黃淑惠");
			emp.setName("劉麗芳");
			tx.commit();
		} catch(Exception ex){
			if (tx!= null) tx.rollback();
		} finally {
			session.close();
		}
		
		HibernateUtils.getSessionFactory().close();
	}    
}