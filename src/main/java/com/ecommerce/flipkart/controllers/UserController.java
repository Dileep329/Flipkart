package com.ecommerce.flipkart.controllers;

import com.ecommerce.flipkart.models.User;
import com.ecommerce.flipkart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/test")
    public String test(){
        return "User is able to access this controller";
    }

    @GetMapping("/testAdmin")
    public String adminTest(){
        return "Admin is able to access this controller";
    }

    @GetMapping("/testSeller")
    public String sellerTest(){
        return "Seller is able to access this controller";
    }
}
