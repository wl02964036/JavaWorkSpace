package jut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch03._00.model.BookBean;
import ch03._00.utils.HibernateUtils;

public class MyTestUnit2 {
	SessionFactory factory;
	Session session;
	Transaction tx;
	@Before
	public void setUp() throws Exception {
		factory = HibernateUtils.getSessionFactory();
		session = factory.getCurrentSession();
		tx = session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("3.--------------------");
		tx.commit();
		System.out.println("4.--------------------");
		factory.close();
	}

	@Test
	public void test() {
		BookBean bean1 = new BookBean(null, "美麗人生", "林小真", 450.0, 50);
		session.save(bean1);
		session.save(bean1);
		session.save(bean1);
		bean1.setPrice(400.0);
	}

}
