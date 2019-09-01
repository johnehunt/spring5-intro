package com.midmarsh.hello.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.midmarsh.spring.hello.bean.AppConfig;

public class Application {

	public static void main(String[] args) throws Exception {
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			System.out.println("Waiting for user input to finish");
			System.in.read();
		}
	}
}
