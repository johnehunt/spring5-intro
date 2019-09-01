package com.midmarsh.spring.main;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContainerMain {
	public static void main(String[] args) throws IOException {
		try (ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml")) {
			System.out.println("Wating for messages");
			System.in.read();
		}
	}
}
