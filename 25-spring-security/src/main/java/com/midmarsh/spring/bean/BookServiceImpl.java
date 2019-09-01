package com.midmarsh.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class BookServiceImpl implements BookService {

	public boolean buy(int isbn, double amount) {
		return true;
	}

	public String getBook(int isbn) {
		return "Java for Practitioners";
	}

}
