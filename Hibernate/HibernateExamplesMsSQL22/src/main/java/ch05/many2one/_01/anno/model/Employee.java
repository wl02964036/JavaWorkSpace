package ch05.many2one._01.anno.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_UNI")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String employeeName;
	// 只有@OneToOne, @OneToMany 可以使用 orphanRemoval = true
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employer_id")
	private Employer employer;

	public Employee() {
	}

	public Employee(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	@Override
	public String toString() {
		return "員工 [編號=" + id + ", 員工姓名=" + employeeName + ", 雇主姓名=" + employer.getEmployerName() + "]";
	}

}
