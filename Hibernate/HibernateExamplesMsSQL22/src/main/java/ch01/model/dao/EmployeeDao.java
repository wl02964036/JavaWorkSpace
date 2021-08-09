package ch01.model.dao;

import java.util.List;

import ch01.model.Employee;

public interface EmployeeDao {

	// 新增一筆Employee物件到資料庫
	Object save(Employee emp);

	// 經由Session介面的get()查詢資料庫內的紀錄
	Employee get(int pk);

	// 查詢所有紀錄
	List<Employee> getAllEmployees();

	void close();

	Employee findByEmployeeId(String id);

}