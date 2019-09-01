package com.midmarsh.spring.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.spring.beans.HelloWorld;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("main - Starting Main Application!");
		ConfigurableApplicationContext context = null;
		try {
			System.out.println("main - Loading bean-context.xml");
			context = new ClassPathXmlApplicationContext("bean-context.xml");
			System.out.println("main - Requesting HelloWorld bean");
			HelloWorld bean = context.getBean(HelloWorld.class);
			System.out.println(bean.getMessage("John"));
		} finally {
			System.out.println("main - Closing application context");
			if (context != null) context.close();
		}
		System.out.println("main - Existing Main Application!");
    }
}
