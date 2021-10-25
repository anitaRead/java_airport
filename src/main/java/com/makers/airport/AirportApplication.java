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

	public String takeOff(String planeName) {
		int planeInd = planes.indexOf(planeName);
		if (planeInd == -1) {
			return "This plane is not in the hangar!";
		} else {
			planes.remove(planeName);
			return planeName + " has successfully taken off!";
		}
	}

	public boolean inHangar(String planeName){
		return 0 > planes.indexOf(planeName);
	}

	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

}
