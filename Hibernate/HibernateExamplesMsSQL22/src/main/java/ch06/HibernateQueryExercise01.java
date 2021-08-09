package ch06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch06.model.Employee;

public class HibernateQueryExercise01 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "FROM Employee  emp";
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<Employee> emps = session.createQuery(hql).getResultList();
			for (Employee e : emps) {
				System.out.println(e.getName()+ ", " +e.getSalary() + ", " + e.getBirthday());
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

	}

}
