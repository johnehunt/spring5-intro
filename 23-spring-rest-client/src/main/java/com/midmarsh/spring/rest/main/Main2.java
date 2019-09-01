package com.midmarsh.spring.rest.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.midmarsh.spring.rest.client.UsersServiceClient;
import com.midmarsh.spring.rest.config.RestClientConfig;

public class Main2 {

	public static void main(String[] args) {
		System.out.println("Starting Main Application!");
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(RestClientConfig.class)) {
			UsersServiceClient client = ctx.getBean(UsersServiceClient.class);
			String result = client.getUser("John");
			System.out.println(result);
		}
		System.out.println("Exiting Main Application!");
	}

}
