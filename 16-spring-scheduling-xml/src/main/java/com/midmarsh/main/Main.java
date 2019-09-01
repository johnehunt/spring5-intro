package com.midmarsh.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			System.out.println("Waiting for user input to finish");
			System.in.read();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
