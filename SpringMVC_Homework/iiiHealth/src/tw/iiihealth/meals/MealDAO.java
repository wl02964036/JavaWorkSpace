package tw.iiihealth.meals;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("MealDAO")
@Transactional
public class MealDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	// 新增資料
	public boolean insert(MealBean m) {
		Session session = sessionFactory.getCurrentSession();
		Serializable sta = session.save(m);

		if (sta != null) {
			return true;
		}

		return false;
	}

	// 查詢全部
	public ArrayList<MealBean> queryAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM MealBean";
		Query<MealBean> rs = session.createQuery(hql, MealBean.class);
		ArrayList<MealBean> list = (ArrayList<MealBean>) rs.getResultList();

		return list;
	}

	// 拿取單筆
	public MealBean searchByName(String name) {

		Session session = sessionFactory.getCurrentSession();
		String hql = "from MealBean where name=:name";
		Query<MealBean> query = session.createQuery(hql, MealBean.class);
		ArrayList<MealBean> mb = (ArrayList<MealBean>) query.setParameter("name", name).getResultList();
		if (mb != null) {
			for (MealBean mealBean : mb) {
				return mealBean;
			}
		}
		return null;
	}

	// 確認資料是否存在
//	public boolean findByName(String name) throws SQLException {
//		Session session = sessionFactory.getCurrentSession();
//		String hql = "from MealBean where name=:name";
//		Query<MealBean> query = session.createQuery(hql, MealBean.class);
//		
//		if(query ==null) {
//			return false;
//		}
//		return true;
//		
//	}

	// 刪除餐點
	public int deleteByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from MealBean where name=:name";
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
	public int updateByName(MealBean m) {

		Session session = sessionFactory.getCurrentSession();

		String hql = "update MealBean m set m.price=:price, m.material=:material, "
				+ "m.calories=:calories, m.protein=:protein, m.carbohydrates=:carbohydrates,"
				+ " m.fat=:fat, m.store_ID=:store_ID where m.name=:name";

		int count = 0;
		try {
			Query query = session.createQuery(hql);
			query.setParameter("name"          ,m.getName());
			query.setParameter("price"         ,m.getPrice());
			query.setParameter("material"      ,m.getMaterial());
			query.setParameter("calories"      ,m.getCalories());
			query.setParameter("protein"       ,m.getProtein());
			query.setParameter("carbohydrates" ,m.getCarbohydrates() );
			query.setParameter("fat"           ,m.getFat());
			query.setParameter("store_ID"      ,m.getStore_ID());
			
			query.executeUpdate();
			count++;
			
		} catch (Exception e) {
			System.out.println("Error!");
			throw new RuntimeException(e);
		}
		return count;

	}

}
