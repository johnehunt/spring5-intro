package com.midmarsh.spring.store;

import java.io.IOException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws IOException {
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("bookstore.xml")) {
			System.out.println("Press Enter when finished");
			System.in.read();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
