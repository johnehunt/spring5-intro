package com.midmarsh.spring.store;

public class BookStoreImpl implements BookStore {
	
	private String name;
	private Book book;
	
	public BookStoreImpl(String name) { 
		this.name = name; 
	}
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Book getBook() { 
		System.out.println("Get book");
		return book; 
	}
	public void setBook(Book book) { this.book = book; }

}
