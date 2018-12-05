package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//        System.setProperty("splunk.port", "8001");
        SpringApplication.run(DemoApplication.class, args);
    }
}
