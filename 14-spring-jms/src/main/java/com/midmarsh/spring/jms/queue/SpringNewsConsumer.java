package com.midmarsh.spring.jms.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class SpringNewsConsumer implements MessageListener{
	public void onMessage(Message msg) {
		if (msg instanceof TextMessage) {
            try {
				System.out.println(((TextMessage)msg).getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
        }
	}
}

