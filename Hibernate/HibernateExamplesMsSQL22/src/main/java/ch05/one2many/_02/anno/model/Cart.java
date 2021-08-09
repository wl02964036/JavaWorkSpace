package ch05.one2many._02.anno.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="CART_ANNO_BI")
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private Long id;
	@Column(name="total", columnDefinition="DECIMAL")
	private Double total;
	private String name; 
	// mappedBy="cart" 說明: 
    // Items類別中，用 @ManyToOne修飾的性質(或屬性)名稱，多方必須定義外鍵(@JoinColumn)
	// 加上mappedBy屬性后，本類別就不是Owner
	// 如果省略mappedBy屬性，Hibernate會採用JoinTable來連結兩個表格
	
	// 如果省略cascade={CascadeType.ALL}，Hibernate不會代為儲存三筆Items物件，必須程式自行儲存
	// 
	@OneToMany(mappedBy="cart", cascade={CascadeType.ALL}) 
	private Set<Item> item = new LinkedHashSet<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Item> getItemsAnno() {
		return item;
	}
	public void setItemsAnno(Set<Item> item) {
		this.item = item;
	}
	
}
