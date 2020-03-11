package com.madushan.order.controller;

import com.madushan.order.model.Order;
import com.madushan.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/ordername/{name}")
    public Order getByName(@PathVariable String name) {
        return orderService.findByOrdername(name);
    }
}