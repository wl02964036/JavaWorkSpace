package tw.iiijdbc.conn.dao;

import java.io.Serializable;

public class Member implements Serializable{

	/**
	 * 
	 */
private static final long serialVersionUID = 1L;//Long型別1
	
	private int memberId;
	private String memberName;
	private String memberAddress;
	private String phone;

	public Member() {
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int id) {
		this.memberId = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}