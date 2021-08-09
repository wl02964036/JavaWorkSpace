package hibernate.exercise._01_onetoone_uni;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Patient_UNI")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	//
	@OneToOne (cascade= {CascadeType.PERSIST})
	@JoinColumn(name="fk_mrid")
	MedicalRecord  medicalRecord;

	public Patient(Integer id, String name, MedicalRecord medicalRecord) {
		super();
		this.id = id;
		this.name = name;
		this.medicalRecord = medicalRecord;
	}

	public Patient() {
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

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name 
				+ ", medicalRecord.id=" + medicalRecord.getMrId()  
				+ ", medicalRecord.description=" + medicalRecord.getDescription()  + "]";
	}


}
