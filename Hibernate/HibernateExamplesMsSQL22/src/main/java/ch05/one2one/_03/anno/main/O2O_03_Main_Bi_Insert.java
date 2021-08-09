package ch05.one2one._03.anno.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.one2one._03.anno.model.ParkingSpace;
import ch05.one2one._03.anno.model.Professor;
import ch05.one2one._03.anno.util.HibernateUtils;


//雙向一對一: 教授(Professor)與停車位(ParkingSpace)彼此都可以找到對方。
//雙方都需要存有對方的物件參考。

//雙向一對一: 由教授來找出停車位，由停車位來找出教授
//Step 0: 加上原本應有的註釋(@Entity, @Table, @Id, ....)
//Step 1: 在 Professor類別內定義一個儲存ParkingSpace類別之物件的實例變數
//Step 2: 在此實例變數之getter前面加上@OneToOne與@JoinColumn
//Step 3: 在ParkingSpace類別內定義一個儲存Professor類別之物件的實例變數
//Step 4: 在此實例變數之getter前面加上@OneToOne(mappedBy="parkingSpace")
//完成       
public class O2O_03_Main_Bi_Insert {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Professor p1 = new Professor("劉梅芳Z");
		Professor p2 = new Professor("曾文山Z");
		
		
		ParkingSpace s1 = new ParkingSpace("HS001Z", "華山校區Z");
		ParkingSpace s2 = new ParkingSpace("TP001Z", "台北校區Z");
        p1.setParkingSpace(s1);
        p2.setParkingSpace(s2);
        
        s1.setProfessor(p1);
        s2.setProfessor(p2);

		Transaction tx = session.beginTransaction();
		session.save(s1);
        session.save(s2);
        session.save(p1);
        session.save(p2);
		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
	}
}
