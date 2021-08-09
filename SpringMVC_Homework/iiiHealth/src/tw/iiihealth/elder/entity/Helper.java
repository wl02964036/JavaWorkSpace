package tw.iiihealth.elder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="helper")
public class Helper {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "name")
	private String  name;
	
	@Column(name= "id_number")
	private String  idNumber;
	
	@Column(name= "photo")
	private String  photo;
	
	@Column(name= "phone")
	private String  phone;
	
	@Column(name= "mail")
	private String  mail;
	
	@Column(name= "hour_price")
	private String  hourPrice;
	
	@Column(name= "day_price")
	private String  dayPrice;
	
	@Column(name= "location")
	private String  location;
	
	@Column(name= "document")
	private String  document;
	
	@Column(name= "service")
	private String  service;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getHourPrice() {
		return hourPrice;
	}

	public void setHourPrice(String hourPrice) {
		this.hourPrice = hourPrice;
	}

	public String getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(String dayPrice) {
		this.dayPrice = dayPrice;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	

}
