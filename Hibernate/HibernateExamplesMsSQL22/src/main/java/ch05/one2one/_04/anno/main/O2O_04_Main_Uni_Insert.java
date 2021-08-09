package ch05.one2one._04.anno.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.one2one._04.anno.model.MedicalRecord;
import ch05.one2one._04.anno.model.Patient;
import ch05.one2one._04.anno.util.HibernateUtils;


//完成       
public class O2O_04_Main_Uni_Insert {
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		MedicalRecord  mr1 = new MedicalRecord("君雅的病歷");
		MedicalRecord  mr2 = new MedicalRecord("俊傑的病歷");
		
		Patient p1 = new Patient("章君雅", mr1);
		Patient p2 = new Patient("李俊傑", mr2);
        
		Transaction tx = session.beginTransaction();
		System.out.println("--------------------------------------");
        session.save(p1);
        System.out.println("--------------------------------------");
        session.save(p2);
        System.out.println("--------------------------------------");
		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
	}
}
