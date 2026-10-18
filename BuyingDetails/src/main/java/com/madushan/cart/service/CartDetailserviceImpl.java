package com.madushan.cart.service;

import com.madushan.cart.model.CartDetails;
import com.madushan.cart.repository.CartDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartDetailserviceImpl implements CartDetailsService {

    @Autowired
    CartDetailsRepository cartDetailsRepository;

    public CartDetails save(CartDetails cartDetails){
        return cartDetailsRepository.save(cartDetails);
    }

    @Override
    public Optional<CartDetails> findById(int id) {
        return cartDetailsRepository.findById(id);
    }

    @Override
    public List<CartDetails> findAll() {
        return cartDetailsRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        cartDetailsRepository.deleteById(id);
    }
}
