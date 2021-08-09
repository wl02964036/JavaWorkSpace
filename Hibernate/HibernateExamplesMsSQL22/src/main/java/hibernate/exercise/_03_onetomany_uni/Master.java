package hibernate.exercise._03_onetomany_uni;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Master_Table")
public class Master {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	// 方法一；未使用cascade		
	// @OneToMany
	
	//方法二；使用cascade
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="FK_Master_0125")
	List<Pet>  pets = new LinkedList<>();
	
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

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public String toString() {
		return "Master [id=" + id + ", name=" + name + ", pets=" + pets + "]";
	}
	
	
	
}
