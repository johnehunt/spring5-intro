package com.midmarsh.spring.web;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

@Component
public class HelloWebFilter implements WebFilter {
  
    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, 
      WebFilterChain webFilterChain) {
         
        System.out.println("HelloWebFilter - " + serverWebExchange.getRequest().getPath());
        
        return webFilterChain.filter(serverWebExchange);
    }
}

