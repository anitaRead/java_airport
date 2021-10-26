package com.makers.airport;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


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
		assertEquals(1, airport.planes.size());
		assertEquals("Plane One", airport.planes.get(0));
	}

//	As an air traffic controller
//	So I can get passengers on the way to their destination
//	I want to instruct a plane to take off from an airport and confirm that it is no longer in the airport

//	Take Off
	@Test
	@DisplayName("Should allow planes to take off")
	public void takeOffPlane() {
		airport.landPlane("Plane One");
		assertEquals(1, airport.planes.size());
		assertEquals("Plane One has successfully taken off!", airport.takeOff("Plane One"));
		assertEquals(0, airport.planes.size());
		assertEquals("This plane is not in the hangar!", airport.takeOff("Plane Two"));
	}

//	Check Planes
	@Test
	@DisplayName("Should check hangar for a certain plane")
	public void checkHangar() {
		airport.landPlane("Plane One");
		assertTrue(airport.inHangar("Plane One"));
		assertFalse(airport.inHangar("Plane Three"));
		airport.takeOff("Plane One");
		assertFalse(airport.inHangar("Plane One"));

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
		assertEquals("Failed to land, airport is full!", airport.landPlane("Plane 6"));
		assertEquals(5, airport.planes.size());
		airport.takeOff("Plane " + 1);
		assertEquals("Plane 6 has successfully landed!", airport.landPlane("Plane 6"));
	}

//	As the system designer
//	So that the software can be used at many airports
//	I would like a default airport capacity that can be overridden as appropriate

	@Test
	@DisplayName("Can change the airport capacity")
	public void changeCapacity() {
		assertEquals(5, airport.capacity);
		airport.updateCapacity(8);
		assertEquals(8, airport.capacity);
		for(int i=0; i<5; i++){
			airport.landPlane("Plane " + i);
		}
		assertNotEquals("Failed to land, airport is full!", airport.landPlane("Plane 6"));
		assertEquals(6, airport.planes.size());
	}

//	As an air traffic controller
//	To ensure safety
//	I want to prevent takeoff when weather is stormy

	@Test
	@DisplayName("Prevent take off when weather is stormy")
	public void stormyWeather() {
			airport.landPlane("Plane One");
			assertTrue(airport.inHangar("Plane One"));
			airport.isStormy = true;
			assertEquals("Can not take off while weather is stormy!", airport.takeOff("Plane One"));

	}

//	As an air traffic controller
//	To ensure safety
//	I want to prevent landing when weather is stormy

	@Test
	@DisplayName("Prevent landing when weather is stormy")
	public void getWeather() {
		airport.landPlane("Plane One");
		airport.isStormy = true;
		assertEquals("You can't land, weather is stormy!", airport.landPlane("Plane Two"));
	}

}
