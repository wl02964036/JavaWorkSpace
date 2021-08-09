package ch05.one2one._04.anno.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch05.one2one._04.anno.model.Patient;
import ch05.one2one._04.anno.util.HibernateUtils;

public class O2O_04_Main_Uni_Query {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("找病人(雙向一對一): ");
        Patient p = session.get(Patient.class, 1);
        System.out.println(p);
//        System.out.println("---------------");
//        System.out.println("找病歷(雙向一對一): ");        
//        MedicalRecord mr = session.get(MedicalRecord.class, 1);
//        System.out.println(mr);
		tx.commit();
		session.close();
		System.out.println("程式結束(Done...!!)");
		factory.close();
		
	}

}
