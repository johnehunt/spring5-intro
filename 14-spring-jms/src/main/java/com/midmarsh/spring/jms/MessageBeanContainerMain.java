package com.midmarsh.spring.jms;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageBeanContainerMain {
	public static void main(String[] args) throws IOException {
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("container-context.xml")) {
			System.out.println("Waiting for messages");
			System.in.read();
		}
	}
}
