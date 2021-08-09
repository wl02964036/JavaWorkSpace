package ch01.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch01.model.Department;
import ch01.model.dao.DepartmentDao;
import ch01.util.HibernateUtils;


public class DepartmentDaoImpl implements DepartmentDao {
	
	SessionFactory factory; 
	
	public DepartmentDaoImpl()  { 
		factory = HibernateUtils.getSessionFactory();
	}

	// 經由Session介面的get()查詢資料庫內的紀錄
	
	public Department get(int pk) {
		Department dept = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dept = (Department) session.get(Department.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return dept;
	}

	public void closeFactory() {
		factory.close();
	}

	@Override
	public Object save(Department dept) {
		Object obj = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			obj = session.save(dept);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return obj;
	}
}
