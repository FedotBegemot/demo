package com.example.demo.controller;

import com.example.demo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/orders")
    public void addOrders(@RequestBody final List<Order> orders) {
        orderRepository.saveAll(orders);
    }

    @GetMapping("/orders/")
    public List<Order> findOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    public List<Order> findOrder(@PathVariable final String id) {
        return orderRepository.findAll().stream()
                .filter(val -> val.get_id().equals(id))
                .collect(Collectors.toList());
    }
}
