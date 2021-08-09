package hibernate.exercise._08_onetomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Troop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	String name;
	
    public Troop(Integer id, String name, Set<Soldier> soldiers) {
		this.id = id;
		this.name = name;
		this.soldiers = soldiers;
	}
    
    public Troop() {
	}
    
    public Troop(String name) {
		this.name = name;
	}    

	@OneToMany(mappedBy="troop")
    Set<Soldier> soldiers = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Soldier> getSoldiers() {
		return soldiers;
	}

	public void setSoldiers(Set<Soldier> soldiers) {
		this.soldiers = soldiers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Troop [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", soldiers=");
		builder.append(soldiers);
		builder.append("]");
		return builder.toString();
	}
    
    
   
   
}