package com.midmarsh.ws.spring;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface EchoService {

	@WebMethod(operationName = "get")
	String getMessage(@WebParam(name = "text") String param);

}
