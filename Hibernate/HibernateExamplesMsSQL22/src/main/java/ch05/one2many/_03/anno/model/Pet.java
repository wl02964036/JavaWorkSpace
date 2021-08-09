package ch05.one2many._03.anno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// 無法由多方(Pet)找到一方(Master)，因為並未在Pet內定義Master的實例變數
@Entity
@Table(name = "Pet_UNI")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Pet_Id")
	private Integer id;
	private String petName;
	private String petType;

	 
	public Pet() {
	}

	public Pet(String petName, String petType) {
		super();
		this.petName = petName;
		this.petType = petType;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	// 必須刪除下列敘述，否則程式便可由多方找回到方而形成雙向的ㄧ對多
	// @ManyToOne // 多對ㄧ，多方(Pet類別)內有個儲存ㄧ方(Master類別)物件參考的實例變數
	// @JoinColumn(name="fk_Master_id", nullable=false)
    // Master master;
	// 
	// public Master getMaster() {
	//    return Master;
	// }
	//
	// public void setMaster(Master Master) {
	//    this.Master = Master;
	// }

}
