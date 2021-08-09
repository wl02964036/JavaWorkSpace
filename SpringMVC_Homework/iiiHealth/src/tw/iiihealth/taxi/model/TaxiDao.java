package tw.iiihealth.taxi.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("taxiDao")
@Transactional
public class TaxiDao {

	@Autowired
	private SessionFactory sessionFactory;

	// 搜尋資料
	public List<TaxiBean> select(String taxi) {
		Session session = sessionFactory.openSession();
		
		String hql = "From TaxiBean where tname=:taxi or phone=:taxi or address=:taxi or serCity=:taxi";
		Query<TaxiBean> query = session.createQuery(hql, TaxiBean.class);
		query.setParameter("taxi", taxi);
		
		List<TaxiBean> result = query.list();
		session.close();
		return result;
	}

	// 顯示列表
	public List<TaxiBean> listTaxi() {
		Session session = sessionFactory.openSession();

		String hql = "From TaxiBean";
		Query<TaxiBean> query = session.createQuery(hql, TaxiBean.class);

		List<TaxiBean> result = query.list();
		session.close();
		return result;
	}

	// 新增資料
	public void insertTaxi(TaxiBean newTaxi) {
		Session session = sessionFactory.openSession();

		session.save(newTaxi);
		session.close();
	}

	// 修改資料
	public void updateTaxi(TaxiBean updateTaxi) {
		
		Transaction tx = null;
		try {
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(updateTaxi);
			tx.commit();
			session.close();
			}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
	}

	// 刪除資料
	public void deleteTaxi(TaxiBean deleteTaxi) {
		
		Transaction tx = null;
		try {
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(deleteTaxi);
			tx.commit();
			session.close();
			}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
		
	}

}
