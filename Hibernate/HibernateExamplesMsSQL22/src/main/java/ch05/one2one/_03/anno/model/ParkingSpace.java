package ch05.one2one._03.anno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ParkingSpace_BI")
public class ParkingSpace {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ParkingSpaceID")
	private Integer id;
	private String spaceNo;
	private String location;
	// 表示本類別(ParkingSpace)對應之表格並沒有表示關聯的外鍵欄位，
	// 外鍵欄位必須參考對照類別(Professor)內的parkingSpace性質，該性質含有表示
	// 關聯的資訊
	@OneToOne(mappedBy="parkingSpace")
	private Professor professor;

	public ParkingSpace() {
		super();
	}

	public ParkingSpace(String spaceNo, String location) {
		super();
		this.spaceNo = spaceNo;
		this.location = location;
	}
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(String spaceNo) {
		this.spaceNo = spaceNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public String toString(){
    	return "停車位:" + getSpaceNo() + 
    			", 校區:" + getLocation() + ", 教授: " + getProfessor().getName();
    }    
}
