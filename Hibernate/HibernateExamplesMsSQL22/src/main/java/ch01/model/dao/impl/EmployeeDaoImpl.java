package ch01.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ch01.model.Employee;
import ch01.model.dao.EmployeeDao;
import ch01.util.HibernateUtils;

public class EmployeeDaoImpl implements EmployeeDao {

	SessionFactory factory;

	public EmployeeDaoImpl() {
		factory = HibernateUtils.getSessionFactory();
	}

	public Object save(Employee emp) {
		Session session = factory.getCurrentSession();
		Object key = null;
		key = session.save(emp);
		return key;
	}

	// 經由Session介面的get()查詢資料庫內的紀錄
	public Employee get(int pk) {
		Employee emp = null;
		Session session = factory.getCurrentSession();
		emp = (Employee) session.get(Employee.class, pk);
		return emp;
	}

	// 查詢所有紀錄
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = new ArrayList<Employee>();
		Session session = factory.getCurrentSession();
		allEmployees = session.createQuery("FROM Employee")
							  .getResultList();
		return allEmployees;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Employee findByEmployeeId(String id) {
		Employee emp = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM Employee e WHERE e.employeeId = :mid ";
		List<Employee> list = (List<Employee>) session.createQuery(hql)
				                .setParameter("mid", id)
				                .getResultList();
		if (list.size() > 0) {
			emp = list.get(0);
		}
		return emp;
	}
	
	public void close() {
		factory.close();
	}


}
