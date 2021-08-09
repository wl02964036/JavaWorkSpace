package tw.leonchen.model;

import org.springframework.stereotype.Component;

//等同於 <bean id="human" class="tw.leonchen.model.Human"/>
@Component(value = "human")
public class Human {
	private int hid;
	private String hname;
	private String haddress;
	private String hphone;
	
	public Human() {
	}

	public Human(int hid, String hname, String haddress, String hphone) {
		super();
		this.hid = hid;
		this.hname = hname;
		this.haddress = haddress;
		this.hphone = hphone;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHaddress() {
		return haddress;
	}

	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}

	public String getHphone() {
		return hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	


}
