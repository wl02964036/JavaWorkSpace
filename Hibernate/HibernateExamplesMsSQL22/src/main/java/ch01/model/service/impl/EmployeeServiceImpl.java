package ch01.model.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch01.model.Employee;
import ch01.model.dao.EmployeeDao;
import ch01.model.dao.impl.EmployeeDaoImpl;
import ch01.model.service.EmployeeService;
import ch01.util.HibernateUtils;

//controller呼叫service，service呼叫DAO
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao employeeDao;
	SessionFactory factory;

	public EmployeeServiceImpl() {
		employeeDao = new EmployeeDaoImpl();
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public Object save(Employee emp) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		Object key = null;
		try {
			tx = session.beginTransaction();
			key = employeeDao.save(emp);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return key;
	}

	@Override
	public Employee get(int pk) {
		Employee emp = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			emp = employeeDao.get(pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = new ArrayList<Employee>();

		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			allEmployees = employeeDao.getAllEmployees();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return allEmployees;
	}

	@Override
	public void close() {
		employeeDao.close();
	}

	@Override
	public Employee findByEmployeeId(String id) {
		Employee emp = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			emp = employeeDao.findByEmployeeId(id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return emp;
	}

}
