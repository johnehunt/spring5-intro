package com.midmarsh.spring.books;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component("Bookshop")
public class Bookshop {
	
	@Cacheable("books")
	public Book getBook(String isbn) {
		return new Book("", isbn);
	}
	
	@CacheEvict(value="books", allEntries=true)
	public void clear() {
		
	}

}
