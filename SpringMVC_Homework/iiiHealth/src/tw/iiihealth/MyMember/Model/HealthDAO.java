package tw.iiihealth.MyMember.Model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("healthDAO") // 告訴大家自己是DAO，並自己訂名稱為healthDAO
@Transactional // 自動管理開關交易
public class HealthDAO {

	@Autowired // 自己找SessionFactory給我
	@Qualifier("sessionFactory") // 怕找不到，可以指名sessionFactory
	private SessionFactory sessionFactory;

//新增資料
	public int insertHealth(HealthBean healthData) {

//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		int count = 0;
		try {
			tx = session.beginTransaction();
			
//			String hql = "insert into HealthBean(empno, ename, gender, rocid1, year1, month1, day1, cname1, account1, pwd1, pwd2, email1, phone1, phone2, addr1, addr2, addr3)"
//					+ "select empno, ename, gender, rocid1, year1, month1, day1, cname1, account1, pwd1, pwd2, email1, phone1, phone2, addr1, addr2, addr3 from HealthBean";
//
//			Query query = session.createQuery(hql);
//
//			 query.executeUpdate();
			 
				session.save(healthData);

			count++;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
		session.close();
		return count;
	}

//查詢全部資料
	public List<HealthBean> searchAllHealth() {

//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		String hql = "From HealthBean";
		Query<HealthBean> query = session.createQuery(hql, HealthBean.class);

		List<HealthBean> list = query.getResultList();

		session.close();
		return list;
	}

//查詢單筆資料
	public List<HealthBean> searchHealthByNo(HealthBean healthData) {

//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		String hql = "from HealthBean where empno=:empno";
		Query<HealthBean> query = session.createQuery(hql, HealthBean.class);

		query.setParameter("empno", healthData.getEmpno());

		List<HealthBean> list = query.getResultList();

		session.close();
		return list;

	}

//刪除單筆資料
	public int deleteHealth(HealthBean healthData) {
//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		String hql = "delete from HealthBean where empno=:empno";
		Transaction tx = null;
		int count = 0;
		try {
			tx = session.beginTransaction();

			Query query = session.createQuery(hql);

			query.setParameter("empno", healthData.getEmpno());

			query.executeUpdate();

			count++;

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}

//		int count = 0;
//		session.delete(healthData);
//		count++;
//		
		session.close();
		return count;

	}

	// 修改單筆資料
	public int updateHealth(HealthBean healthData) {

//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		
//		String hql = "update HealthBean set ename=:ename, gender=:gender, rocid1=:rocid1, year1=:year1, month1=:month1, day1=:day1, cname1=:cname1, account1=:account1, pwd1=:pwd1, pwd2=:pwd2, email1=:email1, phone1=:phone1, phone2=:phone2, addr1=:addr1, addr2=:addr2, addr3=:addr3"
//				+ " where empno=:empno";
		
		Transaction tx = null;
		int count = 0;
		try {
			tx = session.beginTransaction();
			
//		Query query = session.createQuery(hql);
//
//		query.setParameter("ename", healthData.getEname());
//		query.setParameter("gender", healthData.getGender());
//		query.setParameter("rocid1", healthData.getRocid1());
//		query.setParameter("year1", healthData.getYear1());
//		query.setParameter("month1", healthData.getMonth1());
//		query.setParameter("day1", healthData.getDay1());
//		query.setParameter("cname1", healthData.getCname1());
//		query.setParameter("account1", healthData.getAccount1());
//		query.setParameter("pwd1", healthData.getPwd1());
//		query.setParameter("pwd2", healthData.getPwd2());
//		query.setParameter("email1", healthData.getEmail1());
//		query.setParameter("phone1", healthData.getPhone1());
//		query.setParameter("phone2", healthData.getPhone2());
//		query.setParameter("addr1", healthData.getAddr1());
//		query.setParameter("addr2", healthData.getAddr2());
//		query.setParameter("addr3", healthData.getAddr3());
//		query.setParameter("empno", healthData.getEmpno());
//
//		int n = query.executeUpdate();
			
				session.update(healthData);

			count++;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
		
		session.close();
		return count;


	}

	// 登陸後查詢資料
	public List<HealthBean> searchHealthByAP(HealthBean healthData) {

//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		String hql = "From HealthBean where account1=:account1 and pwd1=:pwd1";
		
		Query<HealthBean> query = session.createQuery(hql, HealthBean.class);
		query.setParameter("account1", healthData.getAccount1());
		query.setParameter("pwd1", healthData.getPwd1());

		List<HealthBean> list = query.getResultList();

		if (list.toString() != "[]") {
			
			session.close();
			return list;
		}

		session.close();
		return null;

	}

}