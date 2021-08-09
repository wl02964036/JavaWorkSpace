package ch06.hql;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ch06.HibernateUtils;

public class HQL11 {
	public static void main(String[] args) {
		HQL11 hq = new HQL11();
		int n = hq.query11();
		if (n == 1) {
			System.out.println("刪除一筆紀錄");
		} else {
			System.out.println("刪除0筆紀錄");
		}
		HibernateUtils.close();
	}
	public int query11() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		String hql = "DELETE FROM Employee WHERE id = :employee_id";
		int result = 0;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("employee_id", 5);
			result = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
		return result;
	}
}
