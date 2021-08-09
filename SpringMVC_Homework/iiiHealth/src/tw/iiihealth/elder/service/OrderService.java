package tw.iiihealth.elder.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.iiihealth.elder.dao.OrderDao;
import tw.iiihealth.elder.entity.Order;

@Service
public class OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Transactional(rollbackFor = Exception.class)
	public List<Order> getAllOrder() {
		return orderDao.getAllOrder();
	}

	@Transactional(rollbackFor = Exception.class)
	public Order getOrderDetail(int id) {
		return orderDao.getOrderDetail(id);
	}

	@Transactional(rollbackFor = Exception.class)
	public void delete(int id) {
		orderDao.delete(id);
	}

	

}
