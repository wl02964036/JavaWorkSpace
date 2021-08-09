package ch05.many2one._03.anno.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.many2one._03.anno.model.Address;
import ch05.many2one._03.anno.model.Person;
import ch05.many2one._03.anno.util.HibernateUtils;
//一個戶籍地址(Address)可以包含許多人(Person)，而每個人只有一個戶籍地址。
//單向多對ㄧ: 
//只能單方向由Person(多方)找到Address(ㄧ方)，因此Person(多方)必須定義一個能儲存
//Address(ㄧ方)之物件參考的實例變數。[多方有個一]
//
//	private Address address;
//
//Address(ㄧ方)不需要定義儲存多方之物件參考的Set物件。
//

public class M2OMain03_Uni_anno_Insert {
	public static void main(String[] args) {
        Address ad1 = new Address("台北市文山區木柵路二段101號");
        Address ad2 = new Address("台北市北投區北投路135號");
        
        Person p1 = new Person("張君雅(文山區)");
        p1.setAddress(ad1);
        Person p2 = new Person("劉麗芳(文山區)");
        p2.setAddress(ad1);
        // 
        Person p3 = new Person("徐衛國(北投區)");
        p3.setAddress(ad2);
        Person p4 = new Person("林曉芳(北投區)");
        p4.setAddress(ad2);
        
        SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try{
//			session.save(ad1);   // 如果有加Cascade時可省略
			session.save(p1);
			session.save(p2);
			System.out.println("----------------");
			session.save(p3);
			session.save(p4);
			tx.commit();
		} catch(Exception e){
			System.out.println(e);
			if (tx != null) 
				tx.rollback();
		} finally{
			if (session != null)
			session.close();
		}
		HibernateUtils.close();
	}
}
