package com.makers.airport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirportApplication {

	public int landPlane(String plane) {
		return 1;
	}

	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

}
