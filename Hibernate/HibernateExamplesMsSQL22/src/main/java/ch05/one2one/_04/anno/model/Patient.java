package ch05.one2one._04.anno.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	// 一(指本類別：Patient)對一((指對方類別：MedicalRecord)
	@OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn: 指定本類別所對應的表格中，存放外鍵的欄位
	@JoinColumn(name = "FK_MR_id")
// 	@JoinColumn(name="id")
	private MedicalRecord medicalRecord;

	public Patient() {
	}

	public Patient(String name, MedicalRecord medicalRecord) {
		super();
		this.name = name;
		this.medicalRecord = medicalRecord;
	}

	public Integer getId() {
		return id;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
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

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", medicalRecord=" + medicalRecord + "]";
	}

}
