package com.midmarsh.spring.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.midmarsh.spring.beans.BookService;

public class App3 {

	public static void main(String[] args) {
		System.out.println("Main - Starting Application!");
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			System.out.println("Main - requesting BookService");
			BookService service = ctx.getBean(BookService.class);
		}
		System.out.println("Exiting Application!");
	}

}
