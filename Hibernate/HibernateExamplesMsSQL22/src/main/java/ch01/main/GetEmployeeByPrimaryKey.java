package ch01.main;

import ch01.model.Employee;
import ch01.model.service.EmployeeService;
import ch01.model.service.impl.EmployeeServiceImpl;

public class GetEmployeeByPrimaryKey {
	public static void main(String[] args) {
		EmployeeService es = new EmployeeServiceImpl();
		Employee emp = es.get(1);
		System.out.println("----以Session介面的load()方法讀入代理類別的物件--------");
		System.out.println(emp);   
		es.close();
	}
}
