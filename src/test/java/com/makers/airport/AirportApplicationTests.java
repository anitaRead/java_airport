package com.makers.airport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AirportApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void landOnePlane() {
		AirportApplication airport = new AirportApplication();
//		airport.landPlane("planeOne");
		Assertions.assertEquals(1, airport.landPlane("planeOne"));
	}

}
