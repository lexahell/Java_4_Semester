package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
//для проверки через postman http://localhost:8080/departure/add
//{
//    "type": "express",
//    "departureDate": "2000-04-24",
//    "postOfficeId": 3
//}