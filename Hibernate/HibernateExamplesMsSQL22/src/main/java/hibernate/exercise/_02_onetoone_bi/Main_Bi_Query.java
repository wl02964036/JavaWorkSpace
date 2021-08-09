package hibernate.exercise._02_onetoone_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.exercise._02_onetoone_bi.utils.HibernateUtils;



public class Main_Bi_Query {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// 先準備物件
		Patient p = session.get(Patient.class, 3);
		System.out.println(p);
		MedicalRecord m = session.get(MedicalRecord.class, 1);
		System.out.println(m);

		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
	}
}
