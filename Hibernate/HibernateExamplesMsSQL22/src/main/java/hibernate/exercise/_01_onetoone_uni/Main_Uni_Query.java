package hibernate.exercise._01_onetoone_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.exercise._01_onetoone_uni.utils.HibernateUtils;

public class Main_Uni_Query {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// 先準備物件
		Patient p1 = session.get(Patient.class, 5);
		System.out.println(p1);
		System.out.println(p1.toString());
		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
	}
}
