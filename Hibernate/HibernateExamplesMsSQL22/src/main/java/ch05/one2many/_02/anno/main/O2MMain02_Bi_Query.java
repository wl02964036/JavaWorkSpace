package ch05.one2many._02.anno.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.one2many._02.anno.model.Cart;
import ch05.one2many._02.anno.model.Item;
import ch05.one2many._02.anno.util.HibernateUtils;

public class O2MMain02_Bi_Query {

	public static void main(String[] args) {
		
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
		// 查詢特定的Cart物件，在找出其內所有Items
		System.out.println("查詢特定的Cart物件，在找出其內所有Items:");
		Cart c = session.get(Cart.class, 1L); 
		for(Item item: c.getItemsAnno()){
			System.out.println("發現ㄧ個item，id=" + item.getItemId());
		}
		System.out.println("================================");
		// 查詢特定的Item物件，由它找出對應的Cart
		System.out.println("查詢特定的Item物件，由它找出對應的Cart:");
		long itemKey = 3L;
		Item i = session.get(Item.class, itemKey); 
		String cartName = i.getCart().getName();
		System.out.println("item id=" + itemKey + "的購物車為" + cartName);
		
		tx.commit();
		session.close();
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