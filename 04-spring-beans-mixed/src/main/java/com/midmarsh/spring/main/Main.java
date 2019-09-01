package com.midmarsh.spring.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.spring.beans.CalculationService;
import com.midmarsh.spring.beans.MessageService;

public class Main {

	public static void main(String[] args) {
		System.out.println("Main - Starting Application!");
		ConfigurableApplicationContext context = null;
		try {
			System.out.println("Main - requesting Application Context");
			context = new ClassPathXmlApplicationContext("beans.xml");
			
			System.out.println("Main - requesting CalculcationService");
			CalculationService calc = context.getBean("CalculationService", CalculationService.class);
			System.out.println("Main - "+ calc.calc("+", 10, 12));

			System.out.println("Main - requesting MessageService");
			MessageService messageService = context.getBean("MessageService", MessageService.class);
			System.out.println("Main - "+ messageService.getMessage("John"));
		} finally {
			System.out.println("Closing Application Context");
			// Need to close as it is a 'resource loader'
			if (context != null)
				context.close();
		}
		System.out.println("Exiting Application!");
	}

}
