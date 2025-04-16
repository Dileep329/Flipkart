package com.ecommerce.flipkart.controllers;

import com.ecommerce.flipkart.models.User;
import com.ecommerce.flipkart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
 @RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user){
       return userService.createUser(user);
    }

    @GetMapping("/test")
    public String test(){
        return "User is able to access this controller";
    }
}
