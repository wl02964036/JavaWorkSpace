package ch04.ex01.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="MemberExample")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer pk;
	
    @Column(name="account", columnDefinition="VARCHAR(32)")
	String memberId;
    
	@Column(columnDefinition="VARCHAR(32) NOT NULL")    
	String password;
	
	@Column(columnDefinition="VARCHAR(32) NOT NULL")
	String name;
	
	@Column(columnDefinition="VARCHAR(64)")
	String email;
	
	@Column(columnDefinition="VARCHAR(20)")
	String tel; 
	Integer experience;
	public Member(Integer pk, String memberId, String password, String name, String mail,
			String tel, Integer experience) {
		this.pk = pk;
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.email = mail;
		this.tel = tel;
		this.experience = experience;
	}
	public Member(String memberId, String password, String name, String mail,
			String tel, Integer experience) {
		
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.email = mail;
		this.tel = tel;
		this.experience = experience;
	}
	public Member(Integer pk) {
		this.pk = pk;
	}
	public Member() { }
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public Integer  getPk() {
		return pk;
	}

	public void setPk(Integer  pk) {
		this.pk = pk;
	}
}
