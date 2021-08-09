package tw.iiihealth.taxi.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("locationDao")
@Transactional
public class LocationDao {

	@Autowired
	private SessionFactory sessionFactory;

	// 搜尋資料
	public List<LocationBean> select(String location) {
		Session session = sessionFactory.openSession();
		
		String hql = "From LocationBean where lName=:loc";
		Query<LocationBean> query = session.createQuery(hql, LocationBean.class);
		query.setParameter("loc", location);
		
		List<LocationBean> result = query.list();
		session.close();
		return result;
	}

	// 顯示列表
	public List<LocationBean> listLocation() {
		Session session = sessionFactory.openSession();

		String hql = "From LocationBean";
		Query<LocationBean> query = session.createQuery(hql, LocationBean.class);

		List<LocationBean> result = query.list();
		session.close();
		return result;
	}
	
	// 新增資料
		public void insertLocation(LocationBean newLoc) {
			Session session = sessionFactory.openSession();

			session.save(newLoc);
			session.close();
		}
	
	//撈修改資料
	public LocationBean selectold(int oldLoc) {
		Session session = sessionFactory.openSession();
		
		String hql = "From LocationBean where id=:loc";
		Query<LocationBean> query = session.createQuery(hql, LocationBean.class);
		query.setParameter("loc", oldLoc);
		
		LocationBean result = query.uniqueResult();
		session.close();
		return result;
	}

	
	// 修改資料
	public void updateLocation(LocationBean updateLoc) {
		
		Transaction tx = null;
		try {
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(updateLoc);
			tx.commit();
			session.close();
		}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
		
	}

	// 刪除資料
	public void deleteLocation(LocationBean deleteLoc) {
		
		Transaction tx = null;
		try {
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(deleteLoc);
			tx.commit();
			session.close();
			}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
		
	}

}
