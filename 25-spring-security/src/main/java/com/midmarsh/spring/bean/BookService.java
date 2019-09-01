package com.midmarsh.spring.bean;

import org.springframework.security.access.annotation.Secured;

public interface BookService {
	
	@Secured("ROLE_USER")
	public String getBook(int isbn);
	
	@Secured("ROLE_TELLER")
	public boolean buy(int isbn, double amount);
}
