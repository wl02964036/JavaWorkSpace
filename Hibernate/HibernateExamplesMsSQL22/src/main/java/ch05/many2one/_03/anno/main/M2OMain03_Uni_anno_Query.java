package ch05.many2one._03.anno.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.many2one._03.anno.model.Person;
import ch05.many2one._03.anno.util.HibernateUtils;

// 單向多對ㄧ
public class M2OMain03_Uni_anno_Query {
	public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Person p1 = null, p2 = null, p3 = null, p4 = null;
		try{
			p1 = session.get(Person.class, 1);
			p2 = session.get(Person.class, 2);
			p3 = session.get(Person.class, 3);
			p4 = session.get(Person.class, 4);
			tx.commit();
		} catch(Exception e){
			System.out.println(e);
			if (tx != null) 
				tx.rollback();
		} finally{
			if (session != null)
			session.close();
		}
		HibernateUtils.close();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
	}
}
