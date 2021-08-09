package hibernate.exercise._07_manytomany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.exercise._07_manytomany_bi.utils.HibernateUtils;




public class Main_Uni_Query {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// 先準備物件
		
		System.out.println("--1.----------------------------");
		Author a1 = session.get(Author.class, 1);
		System.out.println("--2.----------------------------");
		System.out.println(a1);
		System.out.println("--3.----------------------------");

		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
	}
}
