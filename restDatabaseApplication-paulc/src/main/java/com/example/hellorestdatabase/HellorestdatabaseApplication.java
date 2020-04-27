package com.example.hellorestdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HellorestdatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellorestdatabaseApplication.class, args);
    }

}
