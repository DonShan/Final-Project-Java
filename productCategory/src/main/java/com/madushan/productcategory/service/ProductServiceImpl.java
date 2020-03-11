package com.madushan.productcategory.service;

import com.madushan.productcategory.model.Product;
import com.madushan.productcategory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }
}
