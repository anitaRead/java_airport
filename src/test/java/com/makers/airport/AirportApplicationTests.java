package com.makers.airport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AirportApplicationTests {

	AirportApplication airport = new AirportApplication();

	@Test
	void contextLoads() {
	}

//	As an air traffic controller
//	So I can get passengers to a destination
//	I want to instruct a plane to land at an airport

	@Test
	@DisplayName("Should land a single plane")
	public void landPlane() {
		airport.landPlane("Plane One");
		Assertions.assertEquals(1, airport.planes.size());
		Assertions.assertEquals("Plane One", airport.planes.get(0));
	}

//	As an air traffic controller
//	So I can get passengers on the way to their destination
//	I want to instruct a plane to take off from an airport and confirm that it is no longer in the airport

//	Take Off
	@Test
	@DisplayName("Should allow planes to take off")
	public void takeOffPlane() {
		airport.landPlane("Plane One");
		Assertions.assertEquals(1, airport.planes.size());
		Assertions.assertEquals("Plane One has successfully taken off!", airport.takeOff("Plane One"));
		Assertions.assertEquals(0, airport.planes.size());
		Assertions.assertEquals("This plane is not in the hangar!", airport.takeOff("Plane Two"));
	}

//	Check Planes
	@Test
	@DisplayName("Should check hangar for a certain plane")
	public void checkHangar() {
		airport.landPlane("Plane One");
		Assertions.assertEquals(true, airport.inHangar("Plane One"));
		Assertions.assertEquals(false, airport.inHangar("Plane Three"));
		airport.takeOff("Plane One");
		Assertions.assertEquals(false, airport.inHangar("Plane One"));

	}

//	As an air traffic controller
//	To ensure safety
//	I want to prevent landing when the airport is full
	@Test
	@DisplayName("Prevent planes landing when airport is full")
	public void airportFull() {
		for(int i=0; i<5; i++){
			airport.landPlane("Plane " + i);
		}
		Assertions.assertEquals("Failed to land, airport is full!", airport.landPlane("Plane 6"));
		Assertions.assertEquals(5, airport.planes.size());
		airport.takeOff("Plane " + 1);
		Assertions.assertEquals("Plane 6 has successfully landed!", airport.landPlane("Plane 6"));
	}

}
