package com.searchorder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.searchorder.entity.Order;


public interface OrderSearchRepository extends MongoRepository<Order, String>{

}
