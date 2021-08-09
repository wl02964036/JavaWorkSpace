package mvcdemo.bean;

import java.io.Serializable;

public class HealthBean implements Serializable {
	private String empno;
	private String ename;
	private String gender;
	private String rocid1;
	private String year1, month1, day1;
	private String cname1;
	private String account1;
	private String pwd1;
	private String pwd2;
	private String email1;
	private String phone1;
	private String phone2;
	private String addr1;
	private String addr2;
	private String addr3;

	public HealthBean() {
	}

	public HealthBean(String pEmpno ,String pName, String pGender, String pRocid1, String pBirthyear, String pBirthmonth, String pBirthday,
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
	
	
	public void setEmpno(String pEmpno) {
		this.empno = pEmpno;
	}
	public String getEmpno() {
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