package com.midmarsh.spring.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.midmarsh.spring.beans.CalculationService;
import com.midmarsh.spring.beans.MessageService;
import com.midmarsh.spring.beans.MyConfig;

public class Main {

	public static void main(String[] args) {
		System.out.println("Main - Starting Application!");
		ConfigurableApplicationContext ctx = null;
		try {
			ctx = new AnnotationConfigApplicationContext(MyConfig.class);
			MessageService printer = ctx.getBean(MessageService.class);
			System.out.println(printer.getMessage("John"));
			System.out.println("Main - requesting CalculationService");
			CalculationService calc = ctx.getBean("CalculationService", CalculationService.class);
			System.out.println("Main - " + calc.calc("+", 10, 12));
		} finally {
			System.out.println("Closing Application Context");
			if (ctx != null)
				ctx.close();
		}
		System.out.println("Exiting Application!");
	}

}
