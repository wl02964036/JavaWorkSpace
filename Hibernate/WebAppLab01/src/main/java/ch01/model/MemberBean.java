package ch01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Member_Table")
public class MemberBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer pk;
	
	@Column(name="memberId",columnDefinition="VARCHAR(20)　NOT NULL")
	String id;
	
	String pswd;
	
	@Transient
	String pswd1;
	
	String name;
	
	@Transient
	String address;
	
	public MemberBean() {
		super();
	}
	public MemberBean(String id, String pswd, String name) {
		super();
		this.id = id;
		this.pswd = pswd;
		this.name = name;
	}
	
	public MemberBean(Integer pk, String id, String pswd, String name) {
		super();
		this.pk = pk;
		this.id = id;
		this.pswd = pswd;
		this.name = name;
	}
	public MemberBean(Integer ipk) {
		this.pk = ipk;
	}
	public Integer getPk() {
		return pk;
	}
	public void setPk(Integer pk) {
		this.pk = pk;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPswd1() {
		return pswd1;
	}
	public void setPswd1(String pswd1) {
		this.pswd1 = pswd1;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
