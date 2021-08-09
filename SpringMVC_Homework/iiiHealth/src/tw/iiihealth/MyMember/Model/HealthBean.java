package tw.iiihealth.MyMember.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity 		//	指自己就是java bean	//給Hibernate看的
@Table(name = "comp")		//指bean對應到名為comp的table	//給Hibernate看的
@Component("HealthBean")		//指自己就是java bean，並且名稱為HealthBean  //給Spring看的，重點是HQL要對到這
public class HealthBean {
	
	@Id @Column(name = "empno")
	private int empno;
	
	@Column(name = "ename")
	private String ename;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "rocid1")
	private String rocid1;
	
	@Column(name = "year1")
	private String year1;
	
	@Column(name = "month1")
	private String month1;
	
	@Column(name = "day1")
	private String day1;
	
	@Column(name = "cname1")
	private String cname1;
	
	@Column(name = "account1")
	private String account1;
	
	@Column(name = "pwd1")
	private String pwd1;
	
	@Column(name = "pwd2")
	private String pwd2;
	
	@Column(name = "email1")
	private String email1;
	
	@Column(name = "phone1")
	private String phone1;
	
	@Column(name = "phone2")
	private String phone2;
	
	@Column(name = "addr1")
	private String addr1;
	
	@Column(name = "addr2")
	private String addr2;
	
	@Column(name = "addr3")
	private String addr3;

	public HealthBean() {
	}

	public HealthBean(int pEmpno ,String pName, String pGender, String pRocid1, String pBirthyear, String pBirthmonth, String pBirthday,
			String pCname1, String pAccount1, String pPwd1,String pPwd2, String pEmail1, String pPhone1, String pPhone2,
			String pAddr1, String pAddr2, String pAddr3) {
		
		this.empno = pEmpno;
		this.ename = pName;
		this.gender = pGender;
		this.rocid1 = pRocid1;
		this.year1 = pBirthyear;
		this.month1 = pBirthmonth;
		this.day1 = pBirthday;
		this.cname1 = pCname1;
		this.account1= pAccount1;
		this.pwd1 = pPwd1;
		this.pwd2 = pPwd2;
		this.email1 = pEmail1;
		this.phone1 = pPhone1;
		this.phone2 = pPhone2;
		this.addr1 = pAddr1;
		this.addr2 = pAddr2;
		this.addr3 = pAddr3;
	}
	
	public HealthBean(int pEmpno) {
		this.empno = pEmpno;
	}
	
	public HealthBean(String pAccount1, String pPwd1) {
		this.account1= pAccount1;
		this.pwd1 = pPwd1;
	}
	
	
	public void setEmpno(int pEmpno) {
		this.empno = pEmpno;
	}
	public int getEmpno() {
		return empno;
	}
	
	public void setEname(String pName) {
		this.ename = pName;
	}

	public String getEname() {
		return ename;
	}
	
	public void setGender(String pGender) {
		this.gender = pGender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setRocid1(String pRocid1) {
		this.rocid1 = pRocid1;
	}
	
	public String getRocid1() {
		return rocid1;
	}

	public void setYear1(String pBirthyear) {
		this.year1 = pBirthyear;
	}

	public String getYear1() {
		return year1;
	}

	public void setMonth1(String pBirthmonth) {
		this.month1 = pBirthmonth;
	}

	public String getMonth1() {
		return month1;
	}

	public void setDay1(String pBirthday) {
		this.day1 = pBirthday;
	}

	public String getDay1() {
		return day1;
	}

	public void setCname1(String pCname1) {
		this.cname1 = pCname1;
	}
	
	public String getCname1() {
		return cname1;
	}
	
	public void setAccount1(String pAccount1) {
		this.account1 = pAccount1;
	}

	public String getAccount1() {
		return account1;
	}
	
	public void setPwd1(String pPwd1) {
		this.pwd1 = pPwd1;
	}
	
	public String getPwd1() {
		return pwd1;
	}
	
	public void setPwd2(String pPwd2) {
		this.pwd2 = pPwd2;
	}
	
	public String getPwd2() {
		return pwd2;
	}
	
	public void setEmail1(String pEmail1) {
		this.email1 = pEmail1;
	}
	
	public String getEmail1() {
		return email1;
	}
	
	public void setPhone1(String pPhone1) {
		this.phone1 = pPhone1;
	}
	
	public String getPhone1() {
		return phone1;
	}
	
	public void setPhone2(String pPhone2) {
		this.phone2 = pPhone2;
	}
	
	public String getPhone2() {
		return phone2;
	}
	
	public void setAddr1(String pAddr1) {
		this.addr1 = pAddr1;
	}

	public String getAddr1() {
		return addr1;
	}
	
	public void setAddr2(String pAddr2) {
		this.addr2 = pAddr2;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr3(String pAddr3) {
		this.addr3 = pAddr3;
	}

	public String getAddr3() {
		return addr3;
	}

}