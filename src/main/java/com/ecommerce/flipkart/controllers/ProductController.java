package com.ecommerce.flipkart.controllers;


import com.ecommerce.flipkart.models.Product;
import com.ecommerce.flipkart.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    public String addProduct(@RequestBody Product product){

        return "Product added successfully";
    }

}
