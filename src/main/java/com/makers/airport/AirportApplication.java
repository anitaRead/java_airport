package com.makers.airport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirportApplication {

	public String sayHello(String name) {
		return "Hello, " + name + "!";
	}
	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

}
