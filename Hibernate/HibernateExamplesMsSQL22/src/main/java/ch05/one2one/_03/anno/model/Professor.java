package ch05.one2one._03.anno.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Professor_BI")
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	// 說明本類別(Professor)對應的表格與對照類別(ParkingSpace)為一對一的關係
	@OneToOne(cascade = CascadeType.PERSIST)
	// 表示本類別(Professor)對應之表格含有表示關聯的外鍵欄位，名稱為"FK_ParkingSpace_ID"
	@JoinColumn(name = "FK_ParkingSpace_ID")
	private ParkingSpace parkingSpace;

	public Professor() {
	}

	public Professor(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public String toString() {
		return "教授: " + name + ", 停車位:" + parkingSpace.getSpaceNo() + ", 校區:" + parkingSpace.getLocation();
	}

}
