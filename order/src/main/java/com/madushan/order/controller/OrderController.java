package com.madushan.order.controller;

import com.madushan.order.model.Order;
import com.madushan.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value = {"", "/orderDetails"}, method = RequestMethod.POST)
    public ResponseEntity<Order> save(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(order));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @RequestMapping(value = {"/{orderId}", "/find/{orderId}"}, method = RequestMethod.GET)
    public ResponseEntity<Order> findById(@PathVariable int orderId){

        return ResponseEntity.of(orderService.FinById(orderId));
    }

    @RequestMapping(value = "/ordername/{orderName}", method = RequestMethod.GET)
    public ResponseEntity<Order> getByName(@PathVariable String orderName) {

        Order order = orderService.findByOrdername(orderName);
        return order == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(order);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int orderId) {
        if (!orderService.FinById(orderId).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        orderService.deleteById(orderId);
        return ResponseEntity.noContent().build();
    }
}
