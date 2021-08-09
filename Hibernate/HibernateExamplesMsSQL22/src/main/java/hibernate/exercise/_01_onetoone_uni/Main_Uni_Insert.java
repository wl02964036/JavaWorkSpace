package hibernate.exercise._01_onetoone_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.exercise._01_onetoone_uni.utils.HibernateUtils;

public class Main_Uni_Insert {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// 先準備物件
		MedicalRecord mr1 = new MedicalRecord("君雅的病例");
		MedicalRecord mr2 = new MedicalRecord("小明的病例");
		Patient p1 = new Patient(null, "張君雅", mr1);
		Patient p2 = new Patient(null, "王小明", mr2);
//		session.persist(mr1);
//		session.persist(mr2);
		session.persist(p1);
		session.persist(p2);
		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
	}
}
