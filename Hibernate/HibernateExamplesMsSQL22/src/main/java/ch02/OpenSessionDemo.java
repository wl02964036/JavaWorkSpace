package ch02;

import org.hibernate.Session;

import ch01.util.HibernateUtils;

public class OpenSessionDemo {
	//hash code不同
	public static void main(String[] args) {
		Session session1 = HibernateUtils.getSessionFactory().openSession();
		Session session2 = HibernateUtils.getSessionFactory().openSession();
		System.out.println(session1);
		System.out.println(session2);
		System.out.println(session1.equals(session2));


	}

}
