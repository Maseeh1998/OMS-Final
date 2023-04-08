package com.searchorder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.searchorder.entity.Order;
import com.searchorder.repo.OrderSearchRepository;

@Service
public class OrderService {
	@Autowired
	OrderSearchRepository orderRepository;
	
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}
	
	public Optional<Order> getOrder(String orderId) {
		return orderRepository.findById(orderId);
	}

}
