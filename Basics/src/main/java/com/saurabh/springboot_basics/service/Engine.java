package com.saurabh.springboot_basics.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary // Instead of using qualifier in Car.java, mark one as default
@Component
public class Engine {

    public void start() {
        System.out.println("Petrol Engine started");
    }
}