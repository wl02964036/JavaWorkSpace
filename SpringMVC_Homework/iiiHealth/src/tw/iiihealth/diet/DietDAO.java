package tw.iiihealth.diet;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.iiihealth.meals.MealBean;

@Repository("DietDAO")
@Transactional
public class DietDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	// 新增資料
	public boolean insert(DietBean d) {
		Session session = sessionFactory.getCurrentSession();
		Serializable sta = session.save(d);

		if (sta != null) {
			return true;
		}

		return false;
	}

	// 查詢全部
	public ArrayList<DietBean> queryAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM DietBean";
		Query<DietBean> rs = session.createQuery(hql, DietBean.class);
		ArrayList<DietBean> list = (ArrayList<DietBean>) rs.getResultList();

		return list;
	}

	// 拿取單筆
	public DietBean searchByName(String name) {

		Session session = sessionFactory.getCurrentSession();
		String hql = "from DietBean where name=:name";
		Query<DietBean> query = session.createQuery(hql, DietBean.class);
		ArrayList<DietBean> db = (ArrayList<DietBean>) query.setParameter("name", name).getResultList();
		if (db != null) {
			for (DietBean dietBean : db) {
				return dietBean;
			}
		}
		return null;
	}
	
	// 查詢分類資料方法
	public ArrayList<DietBean> queryType(String type)  {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "from DietBean where type=:type";
		Query<DietBean> query = session.createQuery(hql, DietBean.class);
		ArrayList<DietBean> dbList = (ArrayList<DietBean>) query.setParameter("type", type).getResultList();
		return dbList;

	}

	// 刪除餐點
	public int deleteByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from DietBean where name=:name";
		int count = 0;
		try {
			Query query = session.createQuery(hql);
			query.setParameter("name", name);
			query.executeUpdate();
			count++;
		} catch (Exception e) {
			System.out.println("Error!");
			throw new RuntimeException(e);
		}
		return count;

	}

	// 修改餐點
	public int updateByName(DietBean d) {

		Session session = sessionFactory.getCurrentSession();

		String hql = "update DietBean d set d.type=:type,d.calories=:calories,  "
				+ "d.protein=:protein, d.carbohydrates=:carbohydrates,"
				+ " d.fat=:fat, d.sugar=:sugar , d.na=:na where d.name=:name";

		int count = 0;
		try {
			Query query = session.createQuery(hql);
			query.setParameter("name"          ,d.getName());
			query.setParameter("type"          ,d.getType());
			query.setParameter("calories"      ,d.getCalories());
			query.setParameter("protein"       ,d.getProtein());
			query.setParameter("carbohydrates" ,d.getCarbohydrates() );
			query.setParameter("fat"           ,d.getFat());
			query.setParameter("sugar"         ,d.getSugar());
			query.setParameter("na"            ,d.getNa());
			
			query.executeUpdate();
			count++;
			
		} catch (Exception e) {
			System.out.println("Error!");
			throw new RuntimeException(e);
		}
		return count;

	}
	
}
