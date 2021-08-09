package ch05.one2many._03.anno.main;

import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.one2many._03.anno.model.Master;
import ch05.one2many._03.anno.model.Pet;
import ch05.one2many._03.anno.util.HibernateUtils;
//利用JoinTable來達成『單向一對多』:
//
//一個主人(Master)可以擁有多個寵物(Pet)，而一個寵物只能屬於一個主人。
//由主人(Master)來找出其內所有寵物(Pet)，但無法由寵物(Pet)找到主人(Master)。
//
//口訣: 一對多，一方有個儲存多方物件參考的List/Set物件，簡稱『ㄧ方有個多』
//
//只要主人類別內含有一個能儲存多方物件(寵物類別)的Set/List物件，
//程式就可以由主人找到其內所有寵物。但是由於是單向(Unidirection)的ㄧ對多，
//所以多方不能含有一方的物件參考，否則就會形成雙向(Bidirection)。
//兩個表格要能保有關聯，現在採用JoinTable的做法。
// 
//Step 0: 為Master類別、Pet類別加上應有的註釋(@Entity, @Table, @Id, ....)
//Step 1: Master類別 
//		    由於程式的需求為『由主人(Master)來找出其內的寵物(Pet)』，
//		    因此在Master類別內定義一個儲存Pet(多方)物件參考的Set/List物件。
//Step 2: 在此Set物件對應的getter前加上
//		  @OneToMany(cascade=CascadeType.ALL)
//        
//		  @JoinTable(name="Master_Pet",  // name:JointTable的表格名稱 
//        -- joinColumns說明JointTable內的欄位名稱,
//			1. joinColumns: 主動方，即本類別，即編寫本註釋的類別(Master)，其內的@JoinColumn說明JoinTable內的欄位名稱(JT_Master_Id)與對應的主鍵(Master_Id)
// 			2. inverseJoinColumns: 被動方，即他方類別(Pet)，其內的@JoinColumn說明JoinTable內的欄位名稱(JT_Pet_Id)與對應的主鍵(Pet_Id)        
//			joinColumns={@JoinColumn(name="JT_Master_Id", referencedColumnName="Master_Id")}, 
//			inverseJoinColumns={@JoinColumn(name="JT_Pet_Id", referencedColumnName="Pet_Id")})
//          private Set<Pet> Pet = new LinkedHashSet<>();
//
//Step 3: Pet類別  
//        不需要特別設定

public class O2MMain03_Uni_Insert {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			// 建立SessionFactory物件
			sessionFactory = HibernateUtils.getSessionFactory();
			// 取出Session物件
			session = sessionFactory.openSession();
			System.out.println("得到Session物件");
			// 開啟交易
			tx = session.beginTransaction();
			Master master1 = new Master();
			master1.setName("張軍雅");
			Master master2 = new Master();
			master2.setName("劉美華");

			// Save the Model objects
			Pet pet1 = new Pet("凱蒂貓", "Cat");
			Pet pet2 = new Pet("嘉菲貓", "Cat");
			Pet pet3 = new Pet("霹靂貓", "Cat");
			Pet pet4 = new Pet("史奴比", "Dog");
			Pet pet5 = new Pet("米小奇", "Mouse");

			Set<Pet> petsSet1 = new LinkedHashSet<Pet>();
			petsSet1.add(pet1);
			petsSet1.add(pet2);
			petsSet1.add(pet3);
			// for(Pet pet : petsSet1){
			// session.save(pet);
			// }
			Set<Pet> petsSet2 = new LinkedHashSet<Pet>();
			petsSet2.add(pet4);
			petsSet2.add(pet5);
			// for(Pet pet : petsSet2){
			// session.save(pet);
			// }
			master1.setPets(petsSet1);
			master2.setPets(petsSet2);

			// 如果Master類別使用@OneToMany(cascade= {CascadeType.ALL})
			// 就可以使用 session.save(master1);
			// 如果Master類別使用@OneToMany(cascade= {CascadeType.PERSIST})
			// 就必須使用 session.persist(master1);			
			session.persist(master1); 
			session.persist(master2);

			// Commit transaction
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("發生例外: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("關閉SessionFactory");
				sessionFactory.close();
			}
		}
	}
}
