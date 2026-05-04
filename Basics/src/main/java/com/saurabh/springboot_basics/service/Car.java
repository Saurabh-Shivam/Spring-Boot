package com.saurabh.springboot_basics.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

//    @Autowired   this is field injection (generally not preferred in projects)
    private Engine engine;

    // Constructor Injection (BEST PRACTICE)
    //    public Car(Engine engine) {
    //        this.engine = engine;
    //    }

    public Car(@Qualifier("engine") Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is moving...");
    }
}