package com.midmarsh.spring.service;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class HelloRoutingConfiguration {

	@Bean
	public RouterFunction<ServerResponse> routerFunction(HelloHandler handler) {
		// Can nest paths - but not required
		return RouterFunctions.nest(RequestPredicates.path("/service"),
				RouterFunctions.route(RequestPredicates.GET("/welcome"), handler::hello).filter(new HelloFilterFunction())
						.andRoute(RequestPredicates.POST("/").and(RequestPredicates.contentType(APPLICATION_JSON)),
								handler::saveUser)
						.andRoute(RequestPredicates.GET("/users"), handler::allUsers)
						.andRoute(RequestPredicates.GET("/user/{name}"), handler::getUser)
						.andRoute(RequestPredicates.DELETE("/user/{name}"), handler::delete));
	}

}
