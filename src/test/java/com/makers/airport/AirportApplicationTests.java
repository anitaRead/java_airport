package com.makers.airport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AirportApplicationTests {

	@Test
	void contextLoads() {
	}

//	As an air traffic controller
//	So I can get passengers to a destination
//	I want to instruct a plane to land at an airport

	@Test
	public void landPlane() {
		AirportApplication airport = new AirportApplication();
		Assertions.assertEquals(1, airport.landPlane("planeOne"));
	}

//	As an air traffic controller
//	So I can get passengers on the way to their destination
//	I want to instruct a plane to take off from an airport and confirm that it is no longer in the airport

	@Test
	public void takeOffPlane() {
		AirportApplication airport = new AirportApplication();
		airport.landPlane("Plane One");
		airport.landPlane("Plane Two");
		Assertions.assertEquals(2, airport.planes.size());
		Assertions.assertEquals("Plane Two has successfully taken off!", airport.takeOff("Plane Two"));
		Assertions.assertEquals(1, airport.planes.size());
		Assertions.assertEquals("Plane One", airport.planes.get(0));
	}


}
