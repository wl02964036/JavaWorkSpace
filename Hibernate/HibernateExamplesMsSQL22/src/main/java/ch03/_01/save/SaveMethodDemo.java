package ch03._01.save;

import java.sql.Date;

import ch01.model.Department;
import ch01.model.Employee;
import ch01.model.service.EmployeeService;
import ch01.model.service.impl.EmployeeServiceImpl;

public class SaveMethodDemo {

	public static void main(String[] args) {
		Department dept = new Department(null, "會計部");
		//DepartmentService dservice = new DepartmentServiceImpl();
		Employee emp1 = new Employee(null, "AY001", "孫美芳", "meifong@gmail.com", 
				37500, 46.8, Date.valueOf("1980-04-23"), dept);
		EmployeeService es = new EmployeeServiceImpl();
		
		
		es.save(emp1);
		
	}
}
