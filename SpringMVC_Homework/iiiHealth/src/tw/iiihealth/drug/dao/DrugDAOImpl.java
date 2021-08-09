package tw.iiihealth.drug.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.iiihealth.drug.model.Drug;


@Repository
public class DrugDAOImpl implements DrugDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addDrug(Drug p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public void updateDrug(Drug p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Drug> listDrugs() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Drug> drugList = session.createQuery("from Drug").list();
		for(Drug p : drugList){
		}
		return drugList; 
	}

	@Override
	public Drug getDrugById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Drug p = (Drug) session.load(Drug.class, new Integer(id));
		return p;
	}

	@Override
	public void removeDrug(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Drug p = (Drug) session.load(Drug.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		
	}

}