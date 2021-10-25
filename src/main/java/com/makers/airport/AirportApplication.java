package com.makers.airport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class AirportApplication {

	ArrayList<String> planes = new ArrayList<>();

	public String landPlane(String plane) {
		if(planes.size() < 5) {
			planes.add(plane);
			return plane + " has successfully landed!";
		}
		return "Failed to land, airport is full!";
	}

	public boolean inHangar(String planeName){
		return planes.indexOf(planeName) != -1;
	}

	public String takeOff(String planeName) {
		boolean planeInHangar = inHangar(planeName);

		if (planeInHangar == false) {
			return "This plane is not in the hangar!";
		} else {
			planes.remove(planeName);
			return planeName + " has successfully taken off!";
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

}
