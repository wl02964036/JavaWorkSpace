package hibernate.exercise._01_onetoone_uni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MedicalRecord_UNI")
public class MedicalRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer mrId;
	
	String description;


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

}
