package com.midmarsh.spring.main;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.spring.beans.WelcomeService;

public class App {
	public static void main( String[] args ) {
    	System.out.println("Main - Starting Application!");
		ConfigurableApplicationContext context = null;
		try {
			System.out.println("Main - requesting Application Context");
			context = new ClassPathXmlApplicationContext("beans.xml");
			
			WelcomeService service = context.getBean(WelcomeService.class);
			String result = service.getWelcomeInfo("John", new Date());
			System.out.println("Result: " + result);
			
		} finally {
			System.out.println("Closing Application Context");
			// Need to close as it is a 'resource loader'
			if (context != null)
				context.close();
		}
		System.out.println("Exiting Application!");
    }
}
