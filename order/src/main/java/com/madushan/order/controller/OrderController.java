package com.madushan.order.controller;

import com.madushan.order.model.Order;
import com.madushan.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value = "/orderDetails", method = RequestMethod.POST)
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }



}
