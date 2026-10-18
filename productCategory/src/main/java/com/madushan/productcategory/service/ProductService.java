package com.madushan.productcategory.service;

import com.madushan.productcategory.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(Product product);

    Optional<Product> findById(Integer OrderId);

    Product findByProductname(String productName);

    List<Product> findByPrice(Integer price);

    List<Product> findAll();

    void deleteById(Integer id);
}
