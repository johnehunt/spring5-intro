package com.midmarsh.sample.main;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.spring.beans.WelcomeService;

public class Main {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("bean-context.xml")) {
			WelcomeService service = ctx.getBean(WelcomeService.class);
			String result = service.getWelcomeInfo("John", new Date());
			System.out.println("Result: " + result);
		}
	}

}
