package ch05.one2many._03.anno.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.one2many._03.anno.model.Master;
import ch05.one2many._03.anno.model.Pet;
import ch05.one2many._03.anno.util.HibernateUtils;

public class O2MMain03_Uni_Query {

	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			// 建立SessionFactory物件
			sessionFactory = HibernateUtils.getSessionFactory();
			// 取出Session物件
			session = sessionFactory.openSession();
			System.out.println("得到Session物件");
			// 開啟交易
			tx = session.beginTransaction();
			// 查詢特定的Master物件，在找出其內所有Pets
			System.out.println("查詢特定的Master物件，在找出其內所有Pets:");
			Master m = session.get(Master.class, 1L);
			if (m != null) {
				for (Pet pet : m.getPets()) {
					System.out.println("發現ㄧ個Pet，id=" + pet.getPetName());
				}
			} else {
				System.out.println("查無資料");
			}

			System.out.println("================================");

			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("發生例外: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("關閉SessionFactory");
				sessionFactory.close();
			}
		}
	}
}