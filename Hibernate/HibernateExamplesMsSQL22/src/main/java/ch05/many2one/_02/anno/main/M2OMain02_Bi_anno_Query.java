package ch05.many2one._02.anno.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.many2one._02.anno.model.Department;
import ch05.many2one._02.anno.util.HibernateUtils;

public class M2OMain02_Bi_anno_Query {
	public static void main(String[] args) {
//		Department d1 = new Department("會計部");
//		Department d2 = new Department("客服部");
//		Employee empee1 = new Employee("A001", "張小明", d1);
//		Employee empee2 = new Employee("A015", "李華", d1 );
//		Employee empee3 = new Employee("C002", "何姵伶", d2);
//		Employee empee4 = new Employee("C012", "林小珍", d2);
//		Employee empee5 = new Employee("C016", "劉雪莉", d2);
//		Set<Employee> setA = new HashSet<>();
//		setA.add(empee1);
//		setA.add(empee2);
//		Set<Employee> setC = new HashSet<>();
//		setC.add(empee3); 
//		setC.add(empee4);
//		setC.add(empee5);
//		
//		d1.setSet(setA);
//		d2.setSet(setC);
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		// 建立SessionFactory物件
		sessionFactory = HibernateUtils.getSessionFactory();
		// 取出Session物件
		session = sessionFactory.openSession();
		//開啟交易
		tx = session.beginTransaction();
		
		Department d1 = session.get(Department.class, 2L); 
		System.out.println(d1.getDepName());
		tx.commit();
		session.close();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		System.out.println("-------------------------------");
		System.out.println(d1.getSet().size());
		System.out.println("-------------------------------");
//		Employee e1 = session.get(Employee.class, 8L); 
//		System.out.println(e1);
		//Commit transaction
		tx.commit();
		//System.out.println("購物車ID="+cart.getId());
		
		}catch(Exception e){
			System.out.println("發生例外: "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("關閉SessionFactory");
				sessionFactory.close();
			}
		}
	}
}
