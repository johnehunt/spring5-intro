package com.midmarsh.spring.jms;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.spring.jms.queue.SpringNewsProducer;

public class SpringJMSProducerMain {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("jms-producer.xml")) {
			SpringNewsProducer producer = context.getBean(SpringNewsProducer.class);
			System.out.println("Sending msg");
			producer.simpleSend();
			System.out.println("Message sent");
		}
	}

}
