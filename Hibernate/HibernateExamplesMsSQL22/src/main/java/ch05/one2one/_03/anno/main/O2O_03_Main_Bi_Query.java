package ch05.one2one._03.anno.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.one2one._03.anno.model.ParkingSpace;
import ch05.one2one._03.anno.model.Professor;
import ch05.one2one._03.anno.util.HibernateUtils;


public class O2O_03_Main_Bi_Query {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
        Professor p = session.get(Professor.class, 3);
		tx.commit();
		session.close();
		session = factory.openSession();
		tx = session.beginTransaction();
        ParkingSpace s = session.get(ParkingSpace.class, 6);
		tx.commit();
		System.out.println("程式結束(Done...!!)");
		factory.close();
		System.out.println("顯示Professor資訊:");
		System.out.println(p);
		System.out.println("------------");
		System.out.println("顯示ParkingSpace資訊:");
		System.out.println(s);
	}
}