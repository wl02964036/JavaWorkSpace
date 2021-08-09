package tw.iiihealth.elder.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.iiihealth.elder.entity.Equip;

@Repository
public class EquipDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	
	public List<Equip> getAllequip() {
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Equip> list = session.createQuery("from Equip", Equip.class).getResultList();
		
		return list;
	}

	
	
	
	public void saveEquip(Equip equip) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(equip);
	}




	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from Equip where id=:id").setParameter("id", id).executeUpdate();
	}


	public Equip getUpdate(int id) {
		Session session = sessionFactory.getCurrentSession();
		Equip equip = session.get(Equip.class, id);
		return equip;
	}
	
	
	
	
	
}
