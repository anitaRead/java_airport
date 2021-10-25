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
	public void saysHello() {
		AirportApplication airport = new AirportApplication();
//		airport.sayHello("Bob");
		Assertions.assertEquals("Hello, Bob!", airport.sayHello("Bob"));
	}

}
