package com.midmarsh.calc;

public class Calculator {

	private double memory = 0.0;

	public void add(double d) {
		memory += d;
	}

	public void subtract(double d) {
		memory -= d;
	}
	
	public void divide(double value) {
		if (value == 0) throw new ArithmeticException("DivideByZero");
		memory = memory / value;
	}
	
	public void multiply(double d) {
		memory = memory * d;
	}

	public void clear() {
		memory = 0.0;
	}

	public double result() {
		return this.memory;
	}

}
