package ch01.main;

import ch01.model.Employee;
import ch01.model.service.EmployeeService;
import ch01.model.service.impl.EmployeeServiceImpl;

public class QueryEmployee {
	public static void main(String[] args) {
		EmployeeService es = new EmployeeServiceImpl();
		Employee emp = es.findByEmployeeId("A070");
		System.out.println(emp);
		es.close();
	}
}
