package hibernate.exercise._02_onetoone_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.one2one._01.anno.util.HibernateUtils;

public class Main_Uni_Delete {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// 先準備物件
		

		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
	}
}
