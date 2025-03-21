package com.puja.reactSpringbootfullstack.controller;

import com.puja.reactSpringbootfullstack.entity.Employee;
import com.puja.reactSpringbootfullstack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public Employee register(@RequestBody Employee user) {
        return service.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody Employee user) {

        return service.verify(user);
    }
}