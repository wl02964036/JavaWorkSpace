package ch05.many2one._01.anno.model;
import javax.persistence.*;
//ㄧ個Employer(雇主)對應多個Employee(員工)
@Entity
@Table(name="Employer_UNI")
public class Employer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String employerName;

	public Employer() {	}
	
	public Employer(String employerName) {
		this.employerName = employerName;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	@Override
	public String toString() {
		return "雇主 [編號=" + id + ", 雇主姓名=" + employerName + "]";
	}
	
}