package com.madushan.productcategory.service;

import com.madushan.productcategory.model.Product;
import com.madushan.productcategory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Integer OrderId) {

        return productRepository.findById(OrderId);
    }

    @Override
    public Product findByProductname(String productName) {
        return  productRepository.findByProductname(productName);
    }

    @Override
    public Product findByPrice(Integer price) {

        return  productRepository.findByPrice(price);
    }
}
