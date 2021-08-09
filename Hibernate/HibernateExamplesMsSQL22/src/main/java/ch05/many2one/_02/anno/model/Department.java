package ch05.many2one._02.anno.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Department_Table")
public class Department {
	// 當使用IDENTITY時，主要鍵的資料型態必須是整數或符點數，不可以為char或String
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer depId;
	String depName;
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	Set<Employee> set = new HashSet<>();

	public Department() {
	}

	public Department(String depName) {
		this.depName = depName;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	
	public Set<Employee> getSet() {
		return set;
	}

	public void setSet(Set<Employee> set) {
		this.set = set;
	}

	@Override
	public String toString() {
		String msg = "部門:" + depName + "   員工:";
		for (Employee e : getSet()) {
			msg += " [" + e.getName() + " " + e.getEmployeeId() + "]";
		}
		return msg;
	}
}
