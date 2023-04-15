package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
    @Repository
    public interface OrderRepository extends MongoRepository<Order, String> {

        List<Order> findAll();
}