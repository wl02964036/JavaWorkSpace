package ch06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;

import ch06.model.Employee;

public class HibernateQueryExercise00 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//		String hql = "FROM Employee e";		//指select * from Employee e		//1
//		String hql = "Select e.name,e.salary FROM Employee e";		//2
//		String hql = "Select e.name FROM Employee e";		//3
//		String hql = "Select e.name,e.salary FROM Employee e WHERE e.salary BETWEEN :min AND :max";		//4		//放冒號是表明這是參數而不是一般欄位
		String hql = "Select e.name,e.salary FROM Employee e WHERE e.name = :name ";	//5		//放冒號是表明這是參數而不是一般欄位
		Object obj = new Object();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();	
		   
//		   Query query = session.createQuery(hql);	//必須要有，但程式被合併在session.createQuery(hql).getResultList();
		
//		   List<Employee> emps = session.createQuery(hql).getResultList();	//1
//		   List<Object[]> emps = session.createQuery(hql).getResultList();	//2
//		   List<String[]> emps = session.createQuery(hql).getResultList();	//3
		   
//		   List<Object[]> emps = session.createQuery(hql)	//4
//				    .setParameter("min", 27000)	
//					.setParameter("max", 29500)
//					.getResultList();
		   
		   List<Object[]> emps = session.createQuery(hql)	//5
				    .setParameter("name", "張君雅")	
					.getResultList();
		   
//		   for( Employee e : emps ) {	//1
//			   System.out.println(e);
//		   }
//		   for( Object[] e : emps ) {	//2
//			   System.out.println(e);
//		   }
//		   for( String[] e : emps ) {	//3
//			   System.out.println(e);
//		   }
//		   for( String[] e : emps ) {	//4
//			   System.out.println(e[0] + ", " + e[1]);
//		   }
		   for( Object[] e : emps ) {	//5
			   System.out.println(e[0] + ", " + e[1]);
		   }
		   tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}
