package ch06;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch06.model.Employee;

public class HibernateQueryExercise13 {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "FROM Employee e WHERE e.id = :id";
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();	
		   List<Employee> emps = session.createQuery(hql, Employee.class)
										   .setParameter("id",5)
										   .getResultList();
		   if(emps.size() ==0) {
			   System.out.println("查無此筆紀錄");
		   }else {
			   Employee e =emps.get(0);
			   System.out.println("Employee=" + e);   
		   }
		   		   
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
