package hibernate.exercise._08_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.exercise._08_onetomany.utils.HibernateUtils;


public class InsertMain {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// 先準備物件
		Soldier soldier1 = new Soldier("林小華");
		Soldier soldier2 = new Soldier("王小明");
		Troop t = new Troop("第一連");
		soldier1.setTroop(t);
		soldier2.setTroop(t);
		t.getSoldiers().add(soldier1);
		t.getSoldiers().add(soldier2);
		
		session.save(soldier1);
		session.save(soldier2);
		
		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();

	}

}
