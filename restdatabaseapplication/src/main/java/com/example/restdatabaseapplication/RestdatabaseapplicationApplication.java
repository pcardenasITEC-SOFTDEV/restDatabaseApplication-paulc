package com.example.restdatabaseapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestdatabaseapplicationApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestdatabaseapplicationApplication.class, args);
	}

}
