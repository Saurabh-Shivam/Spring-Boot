package com.saurabh.springboot_basics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/hey")
    public String hey() {
        return "Hey from Spring Boot 🚀";
    }
}
