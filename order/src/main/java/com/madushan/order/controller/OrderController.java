package com.madushan.order.controller;

import com.madushan.order.model.Order;
import com.madushan.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value = "/orderDetails", method = RequestMethod.POST)
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @RequestMapping(value = "find/{OrderId}")
    public Optional<Order> findById(@PathVariable int OrderId){
        return orderService.FinById(OrderId);
    }
    @RequestMapping(value = "/ordername", method = RequestMethod.GET)
    public Order getByName(@PathVariable String oderName) {

        return orderService.findByOrdername(oderName);
    }
}