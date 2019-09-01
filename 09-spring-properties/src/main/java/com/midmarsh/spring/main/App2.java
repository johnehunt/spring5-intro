package com.midmarsh.spring.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.midmarsh.spring.config.DatabaseConfig;


public class App2 {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(DatabaseConfig.class)) {
			DriverManagerDataSource datasource = ctx.getBean("dataSource", DriverManagerDataSource.class);
			System.out.println(datasource);
			System.out.println(datasource.getUrl());
			System.out.println(datasource.getUsername());
			System.out.println(datasource.getPassword());
		}
	}

}
