package hibernate.exercise._03_onetomany_uni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pet_Table")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Override
	public String toString() {
		return "Pet [id=" + id + ", petName=" + petName + ", petType=" + petType + "]";
	}
	
	
}
