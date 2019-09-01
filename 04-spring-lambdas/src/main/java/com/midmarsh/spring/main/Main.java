package com.midmarsh.spring.main;

import org.springframework.context.support.GenericApplicationContext;

import com.midmarsh.spring.beans.DefaultMessageService;
import com.midmarsh.spring.beans.MessageService;

public class Main {

	public static void main(String[] args) {
		System.out.println("Main - Starting Application!");
		GenericApplicationContext context = null;
		try {
			System.out.println("Main - setting up context");
			context = new GenericApplicationContext();
			context.registerBean(MessageService.class, () -> new DefaultMessageService("Welcome"));
			System.out.println("Refresh configuration contetx (initialize beans)");
			context.refresh();
			
			System.out.println("Request Bean");
			MessageService service = context.getBean(MessageService.class);
			System.out.println("Main - " + service.getMessage("John"));

		} finally {
			System.out.println("Closing Application Context");
			// Need to close as it is a 'resource loader'
			if (context != null)
				context.close();
		}
		System.out.println("Exiting Application!");
	}

}
