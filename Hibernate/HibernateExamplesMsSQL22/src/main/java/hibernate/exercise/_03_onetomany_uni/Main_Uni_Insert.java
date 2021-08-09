package hibernate.exercise._03_onetomany_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.exercise._03_onetomany_uni.utils.HibernateUtils;


public class Main_Uni_Insert {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// 先準備物件
		// 方法一；未使用cascade		
//		Master  master1 = new Master();
//		master1.setName("君雅");
//		Pet pet1 = new Pet("黑熊厲害", "Dog");
//		Pet pet2 = new Pet("黑熊可愛", "Cat");
//		master1.getPets().add(pet1);
//		master1.getPets().add(pet2);
//		session.save(pet1);
//		session.save(pet2);
//		session.save(master1);
		// 方法二；使用cascade		
		Master  master1 = new Master();
		master1.setName("君雅2");
		Pet pet1 = new Pet("黑熊厲害2", "Dog");
		Pet pet2 = new Pet("黑熊可愛2", "Cat");
		master1.getPets().add(pet1);
		master1.getPets().add(pet2);
		session.save(master1);

		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
	}
}
