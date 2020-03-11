package com.madushan.productcategory.controller;

import com.madushan.productcategory.model.Product;
import com.madushan.productcategory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
