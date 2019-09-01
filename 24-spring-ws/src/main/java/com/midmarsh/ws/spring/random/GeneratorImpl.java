package com.midmarsh.ws.spring.random;

import java.util.Random;

public class GeneratorImpl implements Generator {
	
	private Random random = new Random();
	private String [] messages = {
		"Hello", "Goodbye", "Good Luck",
		"Welcome", "Heres looking at you"};
	
	public GeneratorImpl() {
		System.out.println("GeneratorImpl.<cons>()");
	}
	
	public String getText() {
		return messages[random.nextInt(messages.length)];
	}

}
