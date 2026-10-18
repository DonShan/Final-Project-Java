package com.madushan.cart.service;

import com.madushan.cart.model.CartDetails;

import java.util.List;
import java.util.Optional;

public interface CartDetailsService {

    CartDetails save(CartDetails cartDetails);

    Optional<CartDetails> findById(int id);

    List<CartDetails> findAll();

    void deleteById(int id);
}
