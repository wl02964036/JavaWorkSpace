package tw.iiihealth.taxi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Entity @Table(name="taxi")
@Component("taxibean")
public class TaxiBean {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="TNAME")
	private String tname;
	@Column(name="PHONE")
	private String phone;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="SERCITY")
	private String serCity;
	@Column(name="CARETAXI")
	private String careTaxi;
	

	public TaxiBean() {
		
	}

	public TaxiBean(int pId, String pTname, String pPhone, String pAddress, String[] pSerCity, String pCareTaxi) {
		
		this.id=pId;
		this.tname=pTname;
		this.phone=pPhone;
		this.address=pAddress;
		this.serCity=String.join(",",pSerCity);
		this.careTaxi=pCareTaxi;
	}
	public TaxiBean(int pId, String pTname, String pPhone, String pAddress, String pSerCity, String pCareTaxi) {
		
		this.id=pId;
		this.tname=pTname;
		this.phone=pPhone;
		this.address=pAddress;
		this.serCity=pSerCity;
		this.careTaxi=pCareTaxi;
	}
	public TaxiBean( String pTname, String pPhone, String pAddress, String[] pSerCity, String pCareTaxi) {
		
		this.tname=pTname;
		this.phone=pPhone;
		this.address=pAddress;
		this.serCity=String.join(",",pSerCity);
		this.careTaxi=pCareTaxi;
	}
	public TaxiBean(String pTname, String pPhone, String pAddress, String pSerCity, String pCareTaxi) {
		
		this.tname=pTname;
		this.phone=pPhone;
		this.address=pAddress;
		this.serCity=pSerCity;
		this.careTaxi=pCareTaxi;
	}
	
	public TaxiBean(String pTname) {
		
		this.tname=pTname;
	}
	public TaxiBean(int pId) {
		
		this.id=pId;
	}
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSerCity() {
		return serCity;
	}

	public void setSerCity(String serCity) {
		this.serCity = serCity;
	}

	public String getCareTaxi() {
		return careTaxi;
	}

	public void setCareTaxi(String careTaxi) {
		this.careTaxi = careTaxi;
	}

	public int getId() {
		return id;
	}

	
}
