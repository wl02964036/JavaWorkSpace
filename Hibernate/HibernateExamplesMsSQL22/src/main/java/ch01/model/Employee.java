package ch01.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Employee_Table")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer pk;
	
	@Column(name = "employee_Id", columnDefinition = "VARCHAR(10) NOT NULL")
	String employeeId;
	
	@Column(name = "empName", columnDefinition = "VARCHAR(50) NOT NULL")
	String name;
	
	Integer salary;
	
	@Column(columnDefinition = "DECIMAL(5,1)")
	Double weight;
	// @Temporal只能用在java.util.Date, @Temporal(TemporalType.DATE)表示刪除時分秒，僅保留年月日。
	@Temporal(TemporalType.DATE)  
	Date birthday;
	
//	Timestamp  orderTime;
	String email;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="snoopy_id")
	Department dept;

	public Employee() {
		super();
	}

	public Employee(Integer pk, String employeeId, String name, String email, 
		  Integer salary,	Double weight, Date birthday, Department dept) {
		this.pk = pk;
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.weight = weight;
		this.birthday = birthday;
		this.dept = dept;
	}

	public Employee(Integer pk) {
		this.pk = pk;
	}

	public Integer getPk() {
		return pk;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Employee [pk=" + pk + ", employeeId=" + employeeId + ", name=" + name + ", salary=" + salary
				+ ", weight=" + weight + ", birthday=" + birthday + ", email=" + email + ", dept=" + dept + "]";
	}
	
}
