package com.oms;




import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.oms.entity.Order;
import com.oms.service.OrderService;

import jakarta.validation.Valid;

@RestController
public class OrderController {// front end
	Logger logger = Logger.getLogger(OrderController.class.getName());
	@Autowired
	OrderService orderService; // dependency Injection ( spring is creating the object)
	private void validateModel(Errors bindingresult) {
		if (bindingresult.hasErrors()) {
			throw new IllegalArgumentException("Invalid Data, Something went wrong!");
		}
		
	}
	@PostMapping("/order")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createOrder(@RequestBody @Valid Order order, BindingResult bindingresult) {
		validateModel(bindingresult);
		System.out.println(order);
		return orderService.createOrder(order);
		//System.out.println(order.getItem());
		// System.out.println(order.getPrice());
	}

	

//id is a path param hence we use path variable 	
	@PutMapping("/order/{id}")
	void updateOrder(@RequestBody @Valid Order order, @PathVariable("id") String orderId, BindingResult bindingresult) {
		 validateModel(bindingresult);
		 System.out.println(orderId);
		 order.setId(orderId);
		 orderService.updateOrder(order);
	}

	@DeleteMapping("/order/{id}")
	 void deleteOrder(@PathVariable("id") String orderId) {
		System.out.println(orderId);
		//return orderService.deleteOrder();
		orderService.deleteOrder(orderId);
	}

}
