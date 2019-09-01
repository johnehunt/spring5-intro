package com.midmarsh.calc;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
	private static final double DELTA = 1e-15;

	private static Calculator calculator = new Calculator();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void add() {
		calculator.add(1);
		calculator.add(1);
		assertEquals(2, calculator.result(), DELTA);
	}

	@Test(expected = ArithmeticException.class)
	public void divideByZero() {
		calculator.divide(0);
	}

	@Ignore("not ready yet")
	@Test
	public void multiply() {
		calculator.add(2);
		calculator.multiply(5);
		assertEquals(10, calculator.result(), DELTA);
	}

}
