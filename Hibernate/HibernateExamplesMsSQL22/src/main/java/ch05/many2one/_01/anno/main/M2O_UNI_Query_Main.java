package ch05.many2one._01.anno.main;

import ch05.many2one._01.anno.model.Employee;
import ch05.many2one._01.anno.model.dao.EmployeeDAO;
import ch05.many2one._01.anno.util.HibernateUtils;
//單向多對一: 由員工(Employee)來找出他的雇主(Employer)，但無法由雇主找到員工。

public class M2O_UNI_Query_Main {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		int key = 1;
		Employee emp = dao.findByPrimaryKey(key);
		if (emp != null) {
			System.out.println(emp);
		} else {
			System.out.println("查無此筆資料, 鍵值=" + key);
		}
		key = 22;
		Employee emp2 = dao.findByPrimaryKey(key);
		if (emp2 != null) {
			System.out.println(emp2);
		} else {
			System.out.println("查無此筆資料, 鍵值=" + key);
		}
		HibernateUtils.close();
	}
}
