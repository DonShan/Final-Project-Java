package com.madushan.order.repository;

import com.madushan.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

   Order findByOrdername(String oderName);

   Order findByiD(Integer orderNo);

}