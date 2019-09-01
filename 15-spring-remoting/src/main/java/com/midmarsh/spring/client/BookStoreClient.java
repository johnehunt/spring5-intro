package com.midmarsh.spring.client;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.midmarsh.spring.store.Book;
import com.midmarsh.spring.store.BookStore;

public class BookStoreClient {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("client-bookstore.xml")) {
			BookStore bookstore = context.getBean(BookStore.class);
			Book book = bookstore.getBook();
			System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor() + " at " + book.getPrice());
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
