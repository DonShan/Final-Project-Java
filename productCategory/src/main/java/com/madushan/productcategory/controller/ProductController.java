package com.madushan.productcategory.controller;

import com.madushan.productcategory.model.Product;
import com.madushan.productcategory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/hello")
    public String HelloProduct(){
        return "Hello product";

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Product> save(@RequestBody Product product) {

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Product> findAll() {

        return productService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> findById(@PathVariable int id){

        return ResponseEntity.of(productService.findById(id));
    }

    @RequestMapping(value = "/name/{productName}", method = RequestMethod.GET)
    public ResponseEntity<Product> findByProductname(@PathVariable String productName){

        Product product = productService.findByProductname(productName);
        return product == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(product);
    }

    @RequestMapping(value = "/price/{price}", method = RequestMethod.GET)
    public List<Product> findByPrice(@PathVariable Integer price){

        return productService.findByPrice(price);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (!productService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
