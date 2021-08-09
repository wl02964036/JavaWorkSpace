package tw.iiihealth.taxi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Table(name="location")
@Component("LocationBean")
public class LocationBean {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="store")
	private String lName;
	@Column(name="class")
	private String type;
	@Column(name="health_insurance")
	private String healthInsurance;
	@Column(name="phone")
	private String phoneNum;
	@Column(name="time")
	private String time;
	@Column(name="close_day")
	private String closeDay;
	@Column(name="city")
	private String city;
	@Column(name="town")
	private String town;
	@Column(name="address")
	private String address;
	@Column(name="brief")
	private String brief;
	@Column(name="site")
	private String siting;
	
	public LocationBean() {}
	
	public LocationBean(int id) {
		this.id=id;
	}
	
	public LocationBean(int id, String lName, String type,String healthInsurance, String phoneNum,String time,
						String closeDay, String city, String town, String address,String brief, String siting) {
		
		this.id = id;
		this.lName = lName;
		this.type = type;
		this.healthInsurance=healthInsurance;
		this.phoneNum = phoneNum;
		this.time=time;
		this.closeDay=closeDay;
		this.city = city;
		this.town = town;
		this.address = address;
		this.brief = brief;
		this.siting= siting;
	}


	public String getSiting() {
		return siting;
	}

	public void setSiting(String siting) {
		this.siting = siting;
	}

	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHealthInsurance() {
		return healthInsurance;
	}

	public void setHealthInsurance(String healthInsurance) {
		this.healthInsurance = healthInsurance;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCloseDay() {
		return closeDay;
	}

	public void setCloseDay(String closeDay) {
		this.closeDay = closeDay;
	}
	
	
}
