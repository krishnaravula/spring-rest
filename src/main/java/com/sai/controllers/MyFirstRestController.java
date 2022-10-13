package com.sai.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstRestController {

    @GetMapping(value = "/hello")
    public String sayHello(){
        return "Hi everyone";
    }
}
