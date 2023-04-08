package com.oms.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oms.entity.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
