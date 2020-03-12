package com.madushan.productcategory.controller;

import com.madushan.productcategory.model.Product;
import com.madushan.productcategory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping
    public String HelloProduct(){
        return "Hello product";

    }

    @RequestMapping(value = "/CustomerDetails", method = RequestMethod.POST)
    public Product save(@RequestBody Product product) {

        return productService.save(product);
    }

    @RequestMapping(value = "/find/{OrderId}", method = RequestMethod.GET)
    public Optional<Product> findById(@PathVariable int OrderId){

        return productService.findById(OrderId);
    }

    @RequestMapping(value = "/productname", method = RequestMethod.GET)
    public Product findByProductname(@PathVariable String productName){

        return productService.findByProductname(productName);
    }

    @RequestMapping(value = "/productPrice", method = RequestMethod.GET)
    public Product findByPrice(@PathVariable String price){

        return findByPrice(price);
    }

}
