package ch05.one2many._02.anno.main;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.one2many._02.anno.model.Cart;
import ch05.one2many._02.anno.model.Item;
import ch05.one2many._02.anno.util.HibernateUtils;
//雙向一對多: 由購物車(Cart)來找出其內所有商品項目(Item)，也可以由商品項目(Item)
//           找到購物車(Cart)。
//口訣: 一對多，一方有個儲存多方物件參考的List/Set物件，簡稱『ㄧ方有個多』
//
//只要購物車類別內含有一個能儲存多方物件(商品項目類別)的List/Set物件，
//程式就可以由購物車找到其內所有商品項目。
//以資料庫的觀點而言就是在Item類別對應的表格內增加一個外鍵欄位，此欄位(指Item物件的欄位)
//儲存該Item物件所屬之購物車的物件參考，Hibernate就可以由購物車(Cart)來找出其內所有商品
//項目(Item)。

//Step 0: 為Cart類別、Item類別加上應有的註釋(@Entity, @Table, @Id, ....)
//Step 1: Cart類別 
//		    由於程式的需求為『由購物車(Cart)來找出其內的商品項目(Item)』，
//		    因此在Cart類別內定義一個儲存Item(多方)物件參考的List/Set物件。
//Step 2: 在此Set物件對應的getter前加上
//        @OneToMany(mappedBy="cart")，"One"代表本類別(Cart), "Many"代表
//        對照類別(Item)。mappedBy的屬性值指對方類別的性質。該性質含有表示關聯的外鍵 。
//        mappedBy屬性表示本類別(Cart)對應之表格並未含有可以表示記錄關聯的外鍵，
//        但是在對照類別(Item)內的cartAnno屬性中有外鍵的相關資訊，即下面的
//        @JoinColumn(name="fk_cart_id", nullable=false)中的
//        fk_cart_id就是Item類別所對應之表格的外鍵欄位。
//        // 下面五行敘述屬於Item類別
//        @ManyToOne  // 多對ㄧ，多方(Item類別)內有個儲存ㄧ方(Cart類別)物件參考的實例變數
//        @JoinColumn(name="cart_id", nullable=false)  
//        public Cart getCart() {
//	         return cart;
//        }
//Step 3: Item類別  
//        在Item類別內定義一個儲存Cart(ㄧ方)物件參考的實例變數。
//        private Cart cart;
//Step 4: cart屬性對應的getter前加上@ManyToOne，"Many"代表本類別(Item), "One"代表
//        對照類別(Cart)。
//Step 5: 再加上@JoinColumn(name="FK_cart_id", nullable=false)說明本類別(Item)
//        對應之表格內的外鍵名稱為何。

public class O2MMain02_Bi_Insert {

	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.setName("範例購物車-3");
		Item item1 = new Item("I001", 10.0, 1, cart);
		Item item2 = new Item("I002", 50.0, 2, cart);
		Item item3 = new Item("I005", 30.0, 4, cart);
		Set<Item> itemsSet = new LinkedHashSet<Item>();
//		itemsSet.add(item1); itemsSet.add(item2);itemsSet.add(item3);
		itemsSet = new LinkedHashSet<>(Arrays.asList(item1, item2, item3));
		
		cart.setItemsAnno(itemsSet);
		double total  = 0 ;
		for(Item item: itemsSet){
			total += item.getUnitPrice() * item.getQuantity();
		}
		cart.setTotal(total);
		
		//------------------------------------
		Cart cart2 = new Cart();
		cart2.setName("範例購物車-6");
		Item item4 = new Item("I004", 18.0, 2, cart2);
		Item item5 = new Item("I006", 66.0, 7, cart2);
		Item item6 = new Item("I008", 37.0, 3, cart2);
		Item item7 = new Item("I010", 35.0, 1, cart2);
		Set<Item> itemsSet2 = new LinkedHashSet<Item>();
		itemsSet2.add(item4); itemsSet2.add(item5);itemsSet2.add(item6);itemsSet2.add(item7);
		
		cart2.setItemsAnno(itemsSet2);
		double total2  = 0 ;
		for(Item item: itemsSet2){
			total2 += item.getUnitPrice() * item.getQuantity();
		}
		cart2.setTotal(total2);
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		// 建立SessionFactory物件
		sessionFactory = HibernateUtils.getSessionFactory();
		// 取出Session物件
		session = sessionFactory.getCurrentSession();
		System.out.println("得到Session物件");
		//開啟交易
		tx = session.beginTransaction();
		
		//Save the Model objects
		session.save(cart);
		session.save(cart2); 
//		for(Items item: itemsSet){
//			session.save(item);
//		}
		//Commit transaction
		tx.commit();
		session.close();
		System.out.println("購物車ID="+cart.getId());
		
		}catch(Exception e){
			System.out.println("發生例外: "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("關閉SessionFactory");
				sessionFactory.close();
			}
		}
	}
}

