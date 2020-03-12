package com.madushan.order.service;

import com.madushan.order.model.Order;

import java.util.Optional;


public interface OrderService {

    Order save(Order order);

    Optional<Order> FinById(Integer OrderId);

    Order findByOrdername(String name);
}
