package com.test.springactuatortest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class GreetingController {

    @GetMapping
    public String greet(){
        return "Hello World!";
    }
}