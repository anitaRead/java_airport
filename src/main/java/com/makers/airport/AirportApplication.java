package com.makers.airport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class AirportApplication {

	ArrayList<String> planes = new ArrayList<>();
	int capacity = 5;
	boolean isStormy = false;

	public void updateCapacity(int newCapacity) {
		capacity = newCapacity;
	}

	public String landPlane(String plane) {
		if(planes.size() < capacity) {
			if(isStormy) {
				return "You can't land, weather is stormy!";
			}
			planes.add(plane);
			return plane + " has successfully landed!";
		}
		return "Failed to land, airport is full!";
	}

	public boolean inHangar(String planeName){
		return planes.contains(planeName);
	}

	public String takeOff(String planeName) {
		boolean planeInHangar = inHangar(planeName);

		if (!planeInHangar) {
			return "This plane is not in the hangar!";
		} else {
			if(isStormy) {
				return "Can not take off while weather is stormy!";
			}
			planes.remove(planeName);
			return planeName + " has successfully taken off!";
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

}
