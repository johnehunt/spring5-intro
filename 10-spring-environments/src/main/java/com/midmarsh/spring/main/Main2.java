package com.midmarsh.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.midmarsh.spring.config.DevAppConfig;
import com.midmarsh.spring.config.ProdAppConfig;
import com.midmarsh.spring.config.TestAppConfig;

public class Main2 {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
			ctx.getEnvironment().setActiveProfiles("dev");
			ctx.register(ProdAppConfig.class, DevAppConfig.class, TestAppConfig.class);
			ctx.refresh();
			
			String name = ctx.getBean("name", String.class);
			System.out.println(name);
			
			// Only works with dev profile - as not set for prod or test
			String info = ctx.getBean("info", String.class);
			System.out.println(info);
		}
	}

}
