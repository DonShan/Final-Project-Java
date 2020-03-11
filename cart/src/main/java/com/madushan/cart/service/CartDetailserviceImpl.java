package com.madushan.cart.service;

import com.madushan.cart.model.CartDetails;
import com.madushan.cart.repository.CartDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartDetailserviceImpl implements CartDetailsService {

    @Autowired
    CartDetailsRepository cartDetailsRepository;

    public CartDetails save(CartDetails cartDetails){
        return cartDetailsRepository.save(cartDetails);
    }
}
