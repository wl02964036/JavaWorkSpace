package ch05.one2many._03.anno.main;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.one2many._03.anno.model.Master;
import ch05.one2many._03.anno.model.Pet;
import ch05.one2many._03.anno.util.HibernateUtils;




public class O2MMain03_Uni_Merge {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// 當修改Pet物件時，若要同時修改Master物件,Master類別的@OneToOne註釋幣必須加上 CascadeType.MERGE
		// 同時要用session的merge方法來更新物件
		Master mas = session.get(Master.class, 1);
		Hibernate.initialize(mas.getPets());
		System.out.println("--------------------------------------");
		tx.commit();
		session.close();
		
		// 注意: 在Master類別中加入 orphanRemoval = true，就會Pet表格中的孤兒移除
		/*
@OneToMany(cascade= {CascadeType.PERSIST, 
	CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH }, 
	orphanRemoval = true
)
 
 
		 */
		
		
		mas.setName("張軍雅New");
		Pet pet1 = new Pet("跳跳虎", "Tiger");
		Pet pet2 = new Pet("巧虎", "Tiger");
		Set<Pet> petsSet1 = mas.getPets();
		
		Iterator<Pet>  it = petsSet1.iterator();
		while (it.hasNext()) {
			Pet pet = it.next();
			if (!pet.getPetName().equals("霹靂貓")) {
				it.remove();
			}
		}	
		petsSet1.add(pet1);
		petsSet1.add(pet2);
		
		session = factory.openSession();
		tx = session.beginTransaction();
		
        session.merge(mas);
        System.out.println("--------------------------------------");
		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
	}
}
