package ch05.one2many._03.anno.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Master_UNI")
public class Master {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Master_Id")
	
	private Integer id;
	private String name;
	
	
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			  CascadeType.REFRESH })
	@JoinTable(name = "Master_Pet", // name:JointTable的表格名稱
	// joinColumns說明JointTable內的欄位名稱, 分為兩個:
	// 1. joinColumns: 主動方，即本類別，即編寫本註釋的類別(Master)，其內的@JoinColumn說明JoinTable內的欄位名稱(JT_Master_Id)與對應的主鍵(Master_Id)
	// 2. inverseJoinColumns: 被動方，即他方類別(Pet)，其內的@JoinColumn說明JoinTable內的欄位名稱(JT_Pet_Id)與對應的主鍵(Pet_Id)
	joinColumns = {
		@JoinColumn(name = "JT_Master_Id", referencedColumnName = "Master_Id") }, 
	inverseJoinColumns = {
		@JoinColumn(name = "JT_Pet_Id", referencedColumnName = "Pet_Id") })
	private Set<Pet> Pet = new LinkedHashSet<>();

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

	
	public Set<Pet> getPets() {
		return Pet;
	}

	public void setPets(Set<Pet> Pet) {
		this.Pet = Pet;
	}

}
