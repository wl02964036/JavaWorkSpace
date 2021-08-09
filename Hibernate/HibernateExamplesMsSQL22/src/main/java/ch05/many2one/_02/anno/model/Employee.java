package ch05.many2one._02.anno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Table")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Column(name = "employee_Id", columnDefinition = "VARCHAR(10) NOT NULL")
	String employeeId;
	@Column(name = "empName", columnDefinition = "VARCHAR(50) NOT NULL")
	String name;
	@ManyToOne
	@JoinColumn(name = "department")
	Department department;

	public Employee() {
	}

	public Employee(String employeeId, String name, Department department) {
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;

	}

	public Employee(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		String msg = "員工: [" + getName() + " " + getEmployeeId() + "]  ";
		msg += department.depName;
		return msg;
	}

}
