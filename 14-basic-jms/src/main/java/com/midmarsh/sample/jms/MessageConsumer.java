package com.midmarsh.sample.jms;

import java.util.Properties;

import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class MessageConsumer {

	public static void main(String[] args) throws Exception {
		Properties env = new Properties();
		env.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		env.put("java.naming.provider.url", "tcp://localhost:61616");
		System.out.println("Get IC");
		InitialContext ic = new InitialContext(env);
		System.out.println("Get Queue Connection Factory");
		QueueConnectionFactory qcf = (QueueConnectionFactory) ic.lookup("ConnectionFactory");
		System.out.println("Get Queue Connection");
		QueueConnection qc = qcf.createQueueConnection();
		System.out.println("QueueSession");
		QueueSession qs = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		System.out.println("Look up queue");
		Queue q = (Queue) ic.lookup("dynamicQueues/news");
		QueueReceiver receiver = qs.createReceiver(q);
		qc.start();
		while (true) {
			Message m = receiver.receive();
			if (m instanceof TextMessage) {
				TextMessage tm = (TextMessage) m;
				System.out.println(tm.getText());
			} else if (m instanceof ObjectMessage) {
				ObjectMessage om = (ObjectMessage) m;
				Object obj = om.getObject();
				System.out.println(obj);
			}
		}
	}
}
