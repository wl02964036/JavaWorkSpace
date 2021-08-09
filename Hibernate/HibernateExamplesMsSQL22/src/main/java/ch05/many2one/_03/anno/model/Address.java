package ch05.many2one._03.anno.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address_Table")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer addressId;
	private String name;

	public Address() {	}
	
	public Address(String name) {
		this.name = name;
	}
	
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

//	@OneToMany(mappedBy="address", cascade=CascadeType.ALL)
//	Set<Person> set = new HashSet<>();	
	
//	public Set<Person> getSet() {
//		return set;
//	}
//
//	public void setSet(Set<Person> set) {
//		this.set = set;
//	}

}
