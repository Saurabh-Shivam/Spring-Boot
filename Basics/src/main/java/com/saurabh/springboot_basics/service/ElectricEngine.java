package com.saurabh.springboot_basics.service;

import org.springframework.stereotype.Component;

@Component
public class ElectricEngine extends Engine {

    @Override
    public void start() {
        System.out.println("Electric Engine started ⚡");
    }
}