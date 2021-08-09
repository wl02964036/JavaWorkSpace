package hibernate.exercise._05_manytoone_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.exercise._05_manytoone_uni.utils.HibernateUtils;



public class Main_Bi_Insert {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// 先準備物件
		// 方法二；使用cascade		
		Employee e1 = new Employee(null, "小明");
		Employee e2 = new Employee(null, "麗芳");
		Employee e3 = new Employee(null, "君豪");
		Department d1 = new Department("資訊部");
		e1.setDepartment(d1);
		e2.setDepartment(d1);
		e3.setDepartment(d1);
		session.save(d1);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
	}
}
