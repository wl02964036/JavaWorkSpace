package ch01.main;

import java.sql.Date;

import ch01.model.Department;
import ch01.model.Employee;
import ch01.model.service.EmployeeService;
import ch01.model.service.impl.EmployeeServiceImpl;

public class FirstHibernate {

	//controller呼叫service，service呼叫DAO
	public static void main(String[] args) {
		Department dept = new Department(null, "行銷部");
		Employee emp1 = new Employee();
		emp1.setName("劉麗芳");
		emp1.setEmployeeId("A033");
		emp1.setSalary(40000);
		emp1.setWeight(50.5);
		emp1.setBirthday(Date.valueOf("1980-1-5"));
		emp1.setDept(dept);
		
		Employee emp2 = new Employee();
		emp2.setName("葉美華");
		emp2.setEmployeeId("A070");
		emp2.setSalary(46000);
		emp2.setWeight(66.7);
		emp2.setBirthday(Date.valueOf("1987-8-9"));
		emp2.setDept(dept);
		
		Employee emp3 = new Employee();
		emp3.setName("林國忠");
		emp3.setEmployeeId("A120");
		emp3.setSalary(37000);
		emp3.setWeight(64.0);
		emp3.setBirthday(Date.valueOf("1992-6-17"));
		emp3.setDept(dept);
		
		//service
		EmployeeService employeeService = new EmployeeServiceImpl();
		employeeService.save(emp1);
		employeeService.save(emp2);
		employeeService.save(emp3);
	}
}
// 執行session物件的persist()方法，將emp物件寫入資料庫的Employee_Table表格
// session.persist(emp); ==> cascade=CascadeType.PERSIST
// session.save(emp); ==> cascade=CascadeType.ALL