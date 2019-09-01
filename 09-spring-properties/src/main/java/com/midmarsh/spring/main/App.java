package com.midmarsh.spring.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class App {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
			DriverManagerDataSource datasource = context.getBean("dataSource", DriverManagerDataSource.class);
			System.out.println(datasource);
			System.out.println(datasource.getUrl());
			System.out.println(datasource.getUsername());
			System.out.println(datasource.getPassword());
		}
	}
}
