package com.searchorder;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.searchorder.entity.Order;
import com.searchorder.service.OrderService;



@RestController
public class OrderSearchController {
	Logger logger = Logger.getLogger(OrderSearchController.class.getName());
	@Autowired
	OrderService orderService; 
	
	@GetMapping("/order")
	List <Order> getOrders() {
		logger.log(Level.WARNING,orderService.hashCode()+"printed");
		return orderService.getOrders();
	}
	
	@GetMapping("/order/{id}")
	Optional<Order> getOrder(@PathVariable("id") String orderId) {
		return orderService.getOrder(orderId);
	}

}
