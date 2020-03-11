package com.madushan.cart.Controller;

import com.madushan.cart.model.CartDetails;
import com.madushan.cart.service.CartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartDetailsService cartDetailsService;

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public CartDetails save(@RequestBody CartDetails cartDetails){

        return  cartDetailsService.save(cartDetails);
    }
}
