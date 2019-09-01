package com.midmarsh.spring.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.spring.beans.SampleBean;

public class App2 {

	public static void main(String[] args) {
		System.out.println("main - Starting Main Application!");
		ConfigurableApplicationContext context = null;
		try {
			System.out.println("main - Loading bean-context2.xml");
			context = new ClassPathXmlApplicationContext("bean-context2.xml");
			System.out.println("main - Requesting bean");
			SampleBean bean = context.getBean(SampleBean.class);
			System.out.println("context.refresh()");
			context.refresh();
			System.out.println("context.stop()");
			context.stop();
			System.out.println("context.start()");
			context.start();
		} finally {
			System.out.println("main - Closing application context");
			if (context != null)
				context.close();
		}
		System.out.println("main - Existing Main Application!");
	}

}
