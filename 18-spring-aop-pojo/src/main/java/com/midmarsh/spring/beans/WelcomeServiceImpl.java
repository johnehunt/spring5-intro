package com.midmarsh.spring.beans;

import java.util.Date;
import java.util.Locale;

import org.springframework.format.datetime.DateFormatter;

public class WelcomeServiceImpl implements WelcomeService {
	
	private DateFormatter formatter;
	private MessageService messageService;
	
	public WelcomeServiceImpl() {
		System.out.println("WelcomeServiceImpl.<cons>()");
	}

	public String getWelcomeInfo(String user, Date date) {
		System.out.println("WelcomeServiceImpl.getWelcomeInfo(" + user + ")");
		String msg = this.messageService.getMessage(user);
		return msg + " it is " + formatter.print(date, Locale.UK);
	}

	public void setFormatter(DateFormatter formatter) {
		System.out.println("WelcomeServiceImpl.setFormatter(" + formatter + ")");
		this.formatter = formatter;
	}

	public void setMessageService(MessageService service) {
		System.out.println("WelcomeServiceImpl.setMessageService(" + service + ")");
		this.messageService = service;
	}

}
