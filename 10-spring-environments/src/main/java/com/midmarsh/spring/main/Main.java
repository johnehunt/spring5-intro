package com.midmarsh.spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class Main {

	public static void main(String[] args) {
		System.out.println("Starting Main Application!");
		try (GenericXmlApplicationContext context = new GenericXmlApplicationContext()) {

			ConfigurableEnvironment env = context.getEnvironment();
			env.setActiveProfiles("dev"); // dev or test or prod
			context.load("classpath*:*Context.xml");
			context.refresh();

			String name = context.getBean("name", String.class);
			System.out.println(name);
			
			// Only works with dev profile - as not set for prod or test
			String info = context.getBean("info", String.class);
			System.out.println(info);
		}
		System.out.println("Existing Main Application!");
	}

}
