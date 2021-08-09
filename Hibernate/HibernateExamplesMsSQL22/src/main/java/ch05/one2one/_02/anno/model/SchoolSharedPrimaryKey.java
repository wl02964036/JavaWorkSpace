package ch05.one2one._02.anno.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "School_Table_02")
public class SchoolSharedPrimaryKey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String schoolName;
	private String address;
	
	public SchoolSharedPrimaryKey() {
	}
	public SchoolSharedPrimaryKey(String schoolName, String address) {
		this.schoolName = schoolName;
		this.address = address;
	}
	
	public SchoolSharedPrimaryKey(Integer id, String schoolName, String address) {
		this.id = id;
		this.schoolName = schoolName;
		this.address = address;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String toString(){
    	return "學校: " + getSchoolName() + ", 校長:" + //getPrincipal().getName() +  
    			", 地址:" + getAddress();
    }	
}
