package com.midmarsh.spring.rest.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.spring.rest.client.UsersServiceClient;

public class Main {
	public static void main(String[] args) {
		System.out.println("Starting Main Application!");
		try (ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("rest-client-context.xml")) {
			UsersServiceClient client = ctx.getBean(UsersServiceClient.class);
			String result = client.getUser("John");
			System.out.println(result);
		}
		System.out.println("Exiting Main Application!");
	}
}
