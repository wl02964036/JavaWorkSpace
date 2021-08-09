package ch05.one2one._04.anno.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer mrId;
	String description;
	@OneToOne(mappedBy="medicalRecord")
	Patient patient;
	public MedicalRecord() {
		super();
	}
	
	public MedicalRecord(String description) {
		super();
		this.description = description;
	}

	public Integer getMrId() {
		return mrId;
	}
	public void setMrId(Integer mrId) {
		this.mrId = mrId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@Override
	public String toString() {
		return "MedicalRecord [mrId=" + mrId + ", description=" + description  + ", patient=" + patient.getName() 
				+ "]";
	}
}
