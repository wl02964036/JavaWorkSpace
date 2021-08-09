package ch05.one2many._02.anno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEMS_ANNO_BI")
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="item_id")
	private String itemId;
	private Double unitPrice;
	private Integer quantity;
	@ManyToOne  // 多對ㄧ，多方(Item類別)內有個儲存ㄧ方(Cart類別)物件參考的實例變數
	// @JoinColumn: 定義多方(Items)所對應表格中的外來鍵為何。省略此註釋，
	// Hibernate會自動產生ㄧ個外來鍵，預設名稱為: 此性質名稱_外來鍵對應的主鍵名稱
	@JoinColumn(name="fk_cart_id", nullable=false)  
	private Cart cart;

	public Item() {
	}

	public Item(String itemId, Double unitPrice, Integer quantity, Cart cart) {
		super();
		this.itemId = itemId;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.cart = cart;
	}
	
	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCartAnno(Cart cart) {
		this.cart = cart;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
