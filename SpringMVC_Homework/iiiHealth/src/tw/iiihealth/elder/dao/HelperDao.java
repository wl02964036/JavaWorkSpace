package tw.iiihealth.elder.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.iiihealth.elder.entity.Helper;

@Repository
public class HelperDao {

	@Autowired
	private SessionFactory sessionfactory;

	public List<Helper> getAllHelper() {

		Session session = sessionfactory.getCurrentSession();
		List<Helper> list = session.createQuery("from Helper", Helper.class).getResultList();

		return list;
	}


	
	
	public void saveHelper(Helper helper) {
		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(helper);
	}

	
	public Helper getUpdate(int id) {
		Session session = sessionfactory.getCurrentSession();
		Helper helper = session.get(Helper.class, id);
		return helper;
	}

	
	public void delete(int id) {
		Session session = sessionfactory.getCurrentSession();

		session.createQuery("delete from Helper where id=:id").setParameter("id", id).executeUpdate();

	}

}
