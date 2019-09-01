package com.midmarsh.ws;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.ws.client.EchoClient;

public class Main {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = 
				new ClassPathXmlApplicationContext("client.xml")) {
			EchoClient client = (EchoClient) ctx.getBean("client");
			String st = client.get();
			System.out.println(st);
		}
	}
}
