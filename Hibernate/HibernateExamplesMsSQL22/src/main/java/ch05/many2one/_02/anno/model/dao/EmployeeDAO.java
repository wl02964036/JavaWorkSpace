package ch05.many2one._02.anno.model.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import ch05.many2one._02.anno.model.Employee;
import ch05.many2one._02.anno.util.HibernateUtils;

public class EmployeeDAO /*implements IEmployeeDAO*/ {
	
	public EmployeeDAO()  {
	}

	// 新增一筆Employee物件到資料庫
	// 
	public Object save(Employee emp){
		System.out.println("EmployeeDAO: save");
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		Object key = null;
		try {
			tx = session.beginTransaction();
			key = session.save(emp);
			System.out.println("key:" + key);
//          取消下列四行的註解，執行後觀察key的變化
			
			
//			key = session.save(emp);
//			System.out.println("key:" + key);
//			key = session.save(emp);
//			System.out.println("key:" + key);
			tx.commit();
		} catch(Exception e){
			if (tx!=null) tx.rollback();
			System.out.println(e.getMessage());
		} 
		return key;
	}
	//
	// 經由Session介面的load()查詢資料庫內的紀錄
	// 
	// System.out.println("EmployeeHBN: load()");
	public Employee load(int pk)  {
		Employee emp = null;
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx =null;
		try {
			tx = session.beginTransaction();
			emp = (Employee)session.load(Employee.class, pk);
//			Hibernate.initialize(emp);   // 提早塞資料
			tx.commit();
		} catch(Exception e){
			if (tx != null) tx.rollback();
			System.out.println(e.getMessage());
		}
		return emp;
	}
	// 經由Session介面的get()查詢資料庫內的紀錄
	// System.out.println("EmployeeDAO: get()");
	public Employee get(int pk) {
		Employee emp = null;
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			emp = (Employee) session.get(Employee.class, pk);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return emp;
	}
	// 更新紀錄
	// System.out.println("EmployeeDAO: update");
	public int updateEmployee(Employee e)  {
		int count = 0 ;
		Employee emp = null;
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx =null;
		try {
			tx = session.beginTransaction();
//			// 更新方法一   
            emp = (Employee)session.get(Employee.class, e.getId()); // Employee: Persistent
			if (emp != null) {
				emp.setEmployeeId(e.getEmployeeId());
				emp.setName(e.getName());
				emp.setDepartment(e.getDepartment());
				count++;
			}
		    //session.update(Employee);
			// 更新方法二
//			session.merge(mem);        // mem為Transient物件
			// 只做新增
			//session.save(mem);
			// 更新方法三			
//			session.saveOrUpdate("Employee", mem);  // mem為Transient物件
			tx.commit();
			
		} catch(Exception ex){
			if (tx != null) tx.rollback();
			System.out.println(ex.getMessage());
		}
		return count;
	}
	// 刪除紀錄
	public int delete(Integer pk)  {
		System.out.println("EmployeeDAO: delete()");
		int count = 0 ;
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx =null;
		try {
			tx = session.beginTransaction();
			Employee mem = new Employee(pk);
			session.delete(mem);   // 缺點:
			count++;
			tx.commit();
		} catch(Exception e){
			if (tx != null) tx.rollback();
		}
		return count;
	}
	// 查詢所有紀錄
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees()  {
		System.out.println("EmployeeDAO: getAllEmployees");
		List<Employee> allEmployees = new ArrayList<Employee>();
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery("From Employee");
			allEmployees = query.getResultList();
			tx.commit();
		} catch(Exception e){
			if ( tx != null ) tx.rollback();
			System.out.println(e.getMessage());
		} 
		return allEmployees;
	}	
}
