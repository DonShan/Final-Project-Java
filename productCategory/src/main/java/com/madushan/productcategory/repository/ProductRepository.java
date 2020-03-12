package com.madushan.productcategory.repository;

import com.madushan.productcategory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByProductname(String productName);

    Product findByPrice(Integer price);
}
