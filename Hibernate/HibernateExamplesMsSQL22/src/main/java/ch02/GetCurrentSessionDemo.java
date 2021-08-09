package ch02;

import org.hibernate.Session;

import ch01.util.HibernateUtils;

public class GetCurrentSessionDemo {
	//hash code一樣
	public static void main(String[] args) {
		Session session1 = HibernateUtils.getSessionFactory().getCurrentSession();
		Session session2 = HibernateUtils.getSessionFactory().getCurrentSession();
		Session session3 = HibernateUtils.getSessionFactory().getCurrentSession();
		Session session4 = HibernateUtils.getSessionFactory().getCurrentSession();
		System.out.println(session1);
		System.out.println(session2);
		System.out.println(session3);
		System.out.println(session4);
		System.out.println(session1.equals(session2));


	}

}
