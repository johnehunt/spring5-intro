package com.midmarsh.sample.main;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.midmarsh.sample.config.AppConfig;
import com.midmarsh.spring.beans.WelcomeService;

public class Main2 {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			WelcomeService service = ctx.getBean(WelcomeService.class);
			String result = service.getWelcomeInfo("John", new Date());
			System.out.println("Result: " + result);
		}
	}

}
