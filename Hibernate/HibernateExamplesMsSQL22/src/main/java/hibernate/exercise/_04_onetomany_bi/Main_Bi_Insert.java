package hibernate.exercise._04_onetomany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.exercise._04_onetomany_bi.utils.HibernateUtils;


public class Main_Bi_Insert {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// 先準備物件
		// 方法二；使用cascade		
		Master  master1 = new Master();
		master1.setName("君雅3");
		Pet pet1 = new Pet("黑熊厲害3", "Dog");
		Pet pet2 = new Pet("黑熊可愛3", "Cat");
		master1.getPets().add(pet1);
		master1.getPets().add(pet2);
		
		pet1.setMaster(master1);
		pet2.setMaster(master1);
		session.save(master1);

		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
	}
}
