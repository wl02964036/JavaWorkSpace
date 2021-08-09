package ch05.many2many._02.anno.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.many2many._02.anno.model.Category;
import ch05.many2many._02.anno.model.Stock;
import ch05.many2many._02.anno.util.HibernateUtils;

public class M2MMain02_Anno_Insert {
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

			Stock stock2317 = new Stock();
			stock2317.setStockCode("2317");
			stock2317.setStockName("鴻海");

			Stock stock2357 = new Stock();
			stock2357.setStockCode("2357");
			stock2357.setStockName("華碩");

			Stock stock2353 = new Stock();
			stock2353.setStockCode("2353");
			stock2353.setStockName("宏碁");

			Stock stock2498 = new Stock();
			stock2498.setStockCode("2498");
			stock2498.setStockName("宏達電");

			Category category1 = new Category("電腦系統", "設計與生產完整的電腦");
			Category category2 = new Category("手機", "生產行動手機");
			Category category3 = new Category("主機板", "電腦用主機母板");

			Set<Category> categories2353 = new HashSet<Category>();
			categories2353.add(category1);
			categories2353.add(category2);

			Set<Category> categories2357 = new HashSet<Category>();
			categories2357.add(category1);
			categories2357.add(category2);
			categories2357.add(category3);

			Set<Category> categories2317 = new HashSet<Category>();
			categories2317.add(category1);
			categories2317.add(category3);

			Set<Category> categories2498 = new HashSet<Category>();
			categories2498.add(category2);

			stock2317.setCategories(categories2317);
			stock2353.setCategories(categories2353);
			stock2357.setCategories(categories2357);
			stock2498.setCategories(categories2498);

			session.save(stock2317);
			session.save(stock2353);
			session.save(stock2357);
			session.save(stock2498);
			tx.commit();
			System.out.println("程式執行完畢");
		} catch (Exception e) {
			System.out.println("Exception occured. " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}
}
