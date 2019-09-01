package com.midmarsh.ws.client;

import com.midmarsh.ws.spring.EchoService;

public class EchoClientImpl implements EchoClient {
	private EchoService service;
	
	public void setService(EchoService service) {
		this.service = service;
	}
	
	public String get() {
		return service.getMessage("John");
	}

}
