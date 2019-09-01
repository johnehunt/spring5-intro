package com.midmarsh.ws.spring;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.midmarsh.ws.spring.random.Generator;

@WebService(name = "echo", endpointInterface = "com.midmarsh.ws.spring.EchoService")
public class EchoServiceImpl implements EchoService {

	private Generator generator;

	public EchoServiceImpl(Generator generator) {
		System.out.println("EchoServiceImpl.<cons>()");
		this.generator = generator;
	}

	@WebMethod(operationName = "get")
	public String getMessage(@WebParam(name = "text") String param) {
		return generator.getText() + " " + param;
	}

}
