package com.midmarsh.spring.beans;

public class DefaultMessageService implements MessageService {
	
	private String message;
	
	public DefaultMessageService(String msg) {
		message = msg;
	}

	public String getMessage(String name) {
		return message + ": " + name;
	}

}
