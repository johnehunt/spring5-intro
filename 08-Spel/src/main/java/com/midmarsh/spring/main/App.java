package com.midmarsh.spring.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.midmarsh.spring.beans.AddressService;

public class App {
	public static void main(String[] args) {
		System.out.println("Starting");
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			AddressService service = ctx.getBean(AddressService.class);
			System.out.println(service.getAddress(0));
		}
		System.out.println("Done");
	}
}
