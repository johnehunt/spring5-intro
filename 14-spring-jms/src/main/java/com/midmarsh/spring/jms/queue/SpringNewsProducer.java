package com.midmarsh.spring.jms.queue;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SpringNewsProducer {
	private JmsTemplate jmsTemplate;

	public void setjmsTemplate(JmsTemplate template) {
		this.jmsTemplate = template;
	}

	public void simpleSend() {
		this.jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				System.out.println("Sending message");
				return session.createTextMessage(new Date() + " - Hello spring queue world");
			}
		});
	}

}
