package hibernate.exercise._04_onetomany_bi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pet_Table_bi")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String petName;
	private String petType;
	
	@ManyToOne
	@JoinColumn(name="FK_Master_0125")
	Master master;
	 
	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}
	 
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
}
