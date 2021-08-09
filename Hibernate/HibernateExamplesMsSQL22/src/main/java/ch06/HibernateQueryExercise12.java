package ch06;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch06.model.Employee;

public class HibernateQueryExercise12 {


	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "FROM Employee e WHERE e.id = :id";
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();	
		   Employee emp = (Employee)session.createQuery(hql)
										   .setParameter("id",5)
										   .getSingleResult();
		   
		   System.out.println(emp);
		   
		   tx.commit();
		} catch(NoResultException e) {
			System.out.println("查無此筆紀錄");
			if (tx != null) {
				tx.rollback();
			}
		}catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}
