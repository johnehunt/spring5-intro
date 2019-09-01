package com.midmarsh.spring.main;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.midmarsh.spring.beans.AppConfig;
import com.midmarsh.spring.beans.WelcomeService;

public class App {
	public static void main(String[] args) {
		System.out.println("Main - Starting Application!");
		ConfigurableApplicationContext ctx = null;
		try {
			System.out.println("Main - setting up Application Context");
			ctx = new AnnotationConfigApplicationContext(AppConfig.class);
			WelcomeService service = ctx.getBean(WelcomeService.class);
			String result = service.getWelcomeInfo("John", new Date());
			System.out.println("Result: " + result);
		} finally {
			System.out.println("Closing Application Context");
			if (ctx != null)
				ctx.close();
		}
		System.out.println("Exiting Application!");
	}
}
