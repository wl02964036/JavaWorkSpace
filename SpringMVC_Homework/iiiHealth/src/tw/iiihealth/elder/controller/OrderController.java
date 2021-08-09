package tw.iiihealth.elder.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.iiihealth.elder.entity.Order;
import tw.iiihealth.elder.service.OrderService;

@Controller
@RequestMapping(path = "/order")
public class OrderController {

	
	@Autowired
	OrderService orderService;
	
	
	@RequestMapping(path = "/list")
	public String AllOrder(Model model) {
		
		List<Order> list = orderService.getAllOrder();
		
		model.addAttribute("list", list);
		
		return "elder/order-list";
	}
	
	
	
	
	
	
	@RequestMapping(path = "/detail")
	public String getOrderDetail(@RequestParam("id") int id, Model model) {
		
		Order order = orderService.getOrderDetail(id);
		
		model.addAttribute("order", order);
		
		return "elder/order-detail";
	}
	
	
	
	@RequestMapping(path = "/delete")
	public  String delete(@RequestParam("detailId") int detailId, @RequestParam("orderId") int orderId, Model model) {
		
		orderService.delete(detailId);
		
		Order order = orderService.getOrderDetail(orderId);
		
		model.addAttribute("order", order);
		
		return "elder/order-detail";
	}
	
	
}
