package com.midmarsh.spring.service;

import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public class HelloFilterFunction implements HandlerFilterFunction<ServerResponse, ServerResponse> {
  
    public Mono<ServerResponse> filter(ServerRequest serverRequest,
      HandlerFunction<ServerResponse> handlerFunction) {
    	
    	System.out.println("HelloFilterFunction: " + handlerFunction);
    	
    	return handlerFunction.handle(serverRequest);
    }

}
