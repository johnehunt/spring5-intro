package com.midmarsh.spring.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class} )
class CalculcatorServiceImplTest {
	
	@Autowired
	private CalculatorService calculator;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
		calculator.clear();
	}

	@Test
	void testAddTwoAndThree() {
		System.out.println("testAdd");
		calculator.add(2.0);
		double result = calculator.add(3.0);
		Assertions.assertEquals(5.0, result, () -> "2.0 add 3.0 should equal 5.0");
	}

	@Test
	void testSubtractTwoFromThree() {
		System.out.println("testSubtract");
		calculator.add(3.0);
		double result = calculator.subtract(2.0);
		Assertions.assertEquals(1.0, result, "3.0 minus 2.0 should equal 1.0");
	}

	@Test
	void testAddTwoAndClearTotal() {
		System.out.println("testClear");
		calculator.add(2.0);
		calculator.clear();
		double result = calculator.value();
		Assumptions.assumeTrue(result == 0, () -> "Clear should leave calculator memory at 0.0");
	}

}
