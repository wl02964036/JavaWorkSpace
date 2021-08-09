package hibernate.exercise._03_onetomany_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.exercise._03_onetomany_uni.utils.HibernateUtils;



public class Main_Uni_Query {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// 先準備物件
		System.out.println("-- 1.------------------------");
		Master m1 = session.get(Master.class, 1);
		System.out.println("-- 2.------------------------");
		System.out.println(m1);
		System.out.println("-- 3.------------------------");

		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
	}
}
