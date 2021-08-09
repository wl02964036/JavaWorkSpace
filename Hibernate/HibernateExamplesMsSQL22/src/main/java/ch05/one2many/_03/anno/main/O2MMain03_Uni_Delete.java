
package ch05.one2many._03.anno.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.one2many._03.anno.model.Master;
import ch05.one2many._03.anno.util.HibernateUtils;

/*
刪除: 
1.	Master類別的 @OneToMany(cascade= {...}) 指定了 CascadeType.REMOVE
	則刪除Master類別的物件時，除了會刪除對應表格內的Master紀錄外，會連帶刪除master_pet
	表格內的相關紀錄，也會刪除Pet表格內的紀錄
	
2.	Master類別的 @OneToMany(cascade= {...}) 如果沒有指定 CascadeType.REMOVE，而且沒有編寫 orphanRemoval = true
        則刪除Master類別的物件時，除了會刪除對應表格內的Master紀錄外，會連帶刪除master_pet
	表格內的相關紀錄，但不會刪除Pet表格內的紀錄。
	
3.	Master類別的 @OneToMany(cascade= {...}) 如果沒有指定 CascadeType.REMOVE，但有編寫 orphanRemoval = true
        則刪除Master類別的物件時，除了會刪除對應表格內的Master紀錄外，會連帶刪除master_pet
	表格內的相關紀錄，也會刪除Pet表格內的紀錄。			
 */
public class O2MMain03_Uni_Delete {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		// 建立SessionFactory物件
		sessionFactory = HibernateUtils.getSessionFactory();
		// 取出Session物件
		session = sessionFactory.openSession();
		System.out.println("得到Session物件");
		//開啟交易
		tx = session.beginTransaction();
		Master mas2 = session.get(Master.class, 2);
		session.delete(mas2);
		//Commit transaction
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

