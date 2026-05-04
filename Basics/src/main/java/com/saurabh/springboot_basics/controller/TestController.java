package com.saurabh.springboot_basics.controller;

import com.saurabh.springboot_basics.service.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private Car car;

    public TestController(Car car) {
        this.car = car;
    }

    @GetMapping("/drive")
    public String drive() {
        car.drive();
        return "Driving...";
    }
}