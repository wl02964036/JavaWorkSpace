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

@Repository("memberDAO") // 告訴大家自己是DAO，並自己訂名稱為memberDAO
@Transactional // 自動管理開關交易
public class MemberDAO {

	@Autowired // 自己找SessionFactory給我
	@Qualifier("sessionFactory") // 怕找不到，可以指名sessionFactory
	private SessionFactory sessionFactory;

//新增資料
	public void inserMember(MemberBean memberData) {

//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(memberData);

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}
	}

//查詢全部資料
	public List<MemberBean> searchAllMember() {

//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		String hql = "From MemberBean";
		Query<MemberBean> query = session.createQuery(hql, MemberBean.class);

		List<MemberBean> list = query.getResultList();

		return list;
	}

//查詢單筆資料
	public List<MemberBean> searchMemberByNo(MemberBean memberData) {

//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		String hql = "from MemberBean where empno=:empno";
		Query<MemberBean> query = session.createQuery(hql, MemberBean.class);

		query.setParameter("memno", memberData.getMemno());

		List<MemberBean> list = query.getResultList();

		return list;

	}

//刪除單筆資料
	public void deleteMember(MemberBean memberData) {
//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		String hql = "delete from MemberBean where memno=:memno";
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Query query = session.createQuery(hql);

			query.setParameter("memno", memberData.getMemno());

			query.executeUpdate();

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}

//		session.delete(memberData);

	}

	// 修改單筆資料
	public void updateMember(MemberBean memberData) {

//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.update(memberData);

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e);
		}

	}

	// 登陸後查詢資料
	public boolean searchMemberByAP(MemberBean memberData) {

//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();

		String hql = "From HealthBean where account1=:account1 and pwd1=:pwd1";

		Query<MemberBean> query = session.createQuery(hql, MemberBean.class);
		query.setParameter("account1", memberData.getCareaccount1());
		query.setParameter("pwd1", memberData.getCarepwd1());

		MemberBean result = query.uniqueResult();

		if (result != null) {
			return true;
		}

		return false;

	}

}