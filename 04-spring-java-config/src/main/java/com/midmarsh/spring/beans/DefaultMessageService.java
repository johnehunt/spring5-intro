package com.midmarsh.spring.beans;

public class DefaultMessageService implements MessageService {
	
	private String message;
	
	public DefaultMessageService(String msg) {
		System.out.println("DefaultMessageService.<cons>(" + msg + ")");
		message = msg;
	}

	public String getMessage(String name) {
		System.out.println("DefaultMessageService.getMessage(" + name + ")");
		return message + ": " + name;
	}

}
