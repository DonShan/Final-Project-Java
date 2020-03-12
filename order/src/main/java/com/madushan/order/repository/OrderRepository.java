package com.madushan.order.repository;

import com.madushan.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

   Order findByOrdername(String oderName);

   Optional<Order> findById(Integer orderNo);

}