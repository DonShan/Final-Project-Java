package com.madushan.cart.Controller;

import com.madushan.cart.model.CartDetails;
import com.madushan.cart.service.CartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartDetailsService cartDetailsService;

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public ResponseEntity<CartDetails> save(@RequestBody CartDetails cartDetails){

        return ResponseEntity.status(HttpStatus.CREATED).body(cartDetailsService.save(cartDetails));
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public List<CartDetails> findAll() {

        return cartDetailsService.findAll();
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ResponseEntity<CartDetails> findById(@PathVariable int id) {

        return ResponseEntity.of(cartDetailsService.findById(id));
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (!cartDetailsService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cartDetailsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
