package com.midmarsh.sample.jms;

import java.util.Date;
import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageProducer {

	/** 
	 * To see the message in the ActiveMQ console - look at http://localhost:8161/admin/
	 */
	public static void main(String[] args) throws NamingException, JMSException {
		Properties env = new Properties();
        env.put("java.naming.factory.initial", 
        		"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        env.put("java.naming.provider.url", "tcp://localhost:61616");
		System.out.println("Get IC");
		InitialContext ic = new InitialContext(env);
		System.out.println("Get Queue Connection Factory");
		QueueConnectionFactory qcf = (QueueConnectionFactory)ic.lookup("ConnectionFactory");
        System.out.println("Get Queue Connection");
        QueueConnection qc = qcf.createQueueConnection();
        System.out.println("QueueSession");
        QueueSession qs = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        System.out.println("Look up queue");
        Queue q = (Queue) ic.lookup("dynamicQueues/news");
        System.out.println("Create message");
        TextMessage message = qs.createTextMessage();
        message.setText("Hello JMS World: " + new Date());
        System.out.println("Send message");
        QueueSender sender = qs.createSender(q);
        sender.send(message);
        qc.close();
	}

}
