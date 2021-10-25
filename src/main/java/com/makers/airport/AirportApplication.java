package com.makers.airport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class AirportApplication {

	ArrayList<String> planes = new ArrayList<>();

	public int landPlane(String plane) {
		planes.add(plane);
		return planes.size();
	}

	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

}
