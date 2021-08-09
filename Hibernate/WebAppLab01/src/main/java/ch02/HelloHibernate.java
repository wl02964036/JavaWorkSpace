package ch02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import _init.HibernateUtils;
import ch01.model.MemberBean;

public class HelloHibernate {

	public static void main(String[] args) {

		MemberBean mb1 = new MemberBean("a1011","Do!ng852","穆拉拉");
		MemberBean mb2 = new MemberBean("3325","Aoo147","珍妮花");
		MemberBean mb3 = new MemberBean("1125","8@poPoo","米小薯");
		
		//同一物件(mb9)寫三次，因為是重複的物件，所以只會commit一次出去
		MemberBean mb9 = new MemberBean("1sdasw","Asdasd","阿囉哈");

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(mb1);
			session.save(mb2);
			session.save(mb3);
			
			session.save(mb9);
			session.save(mb9);
			session.save(mb9);
			
			tx.commit();
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
		}
		factory.close();
	}

}
