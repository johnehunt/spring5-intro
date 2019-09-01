package com.midmarsh.spring.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.spring.books.Book;
import com.midmarsh.spring.books.Bookshop;

public class Main {

	public static void main(String[] args) {
		System.out.println("Starting Main Application!");
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			Bookshop bookshop = context.getBean("Bookshop", Bookshop.class);
			System.out.println("===========================");
			Book book1 = bookshop.getBook("1234");
			System.out.println(book1);
			Book book2 = bookshop.getBook("1235");
			System.out.println(book2);
			Book book3 = bookshop.getBook("1234");
			System.out.println(book3);
			System.out.println("===========================");
		}
		System.out.println("Existing Main Application!");
	}
}
