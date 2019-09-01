package com.midmarsh.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.spring.Person;

public class Main {

	public static void main(String[] args) {
		System.out.println("Starting Main Application!");
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			Person person1 = context.getBean("Person", Person.class);
			System.out.println(person1);

			Person person2 = context.getBean("OtherPerson", Person.class);
			System.out.println(person2);
		} 
		System.out.println("Exiting Main Application!");
	}

}
