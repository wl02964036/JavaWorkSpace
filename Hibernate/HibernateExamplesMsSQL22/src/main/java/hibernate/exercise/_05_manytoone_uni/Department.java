package hibernate.exercise._05_manytoone_uni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department_Table_uni")
public class Department {
	// 當使用IDENTITY時，主要鍵的資料型態必須是整數或符點數，不可以為char或String
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer depId;
	String depName;

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

}
