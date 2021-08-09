package tw.iiihealth.elder.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.iiihealth.elder.entity.Order;

@Repository
public class OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	public List<Order> getAllOrder() {
		Session session = sessionFactory.getCurrentSession();

		List<Order> list = session.createQuery("from Order", Order.class).getResultList();

		return list;
	}


	
	
	public Order getOrderDetail(int id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = session.get(Order.class, id);
		return order;
	}




	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from OrderDetail where id=:id").setParameter("id", id).executeUpdate();
	}


}
