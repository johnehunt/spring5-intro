package com.midmarsh.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.spring.beans.MessageService;

public class App {
	public static void main(String[] args) {
		System.out.println("Starting basic spring with XML config");
		// Obtain the factory
		ApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("bean-context.xml");
			// Get the named bean - old style use of getBean
			MessageService bean1 = (MessageService) context.getBean("MessageService");
			// Use it
			System.out.println(bean1.getMessage("John"));
			// Newer form of getBean
			// MessageService bean2 = factory.getBean(MessageService.class);
			MessageService bean2 = context.getBean("MessageService", MessageService.class);
			System.out.println(bean2.getMessage("John"));
		} finally {
			if (context != null) {
				((ConfigurableApplicationContext) context).close();
			}
		}
	}
}
