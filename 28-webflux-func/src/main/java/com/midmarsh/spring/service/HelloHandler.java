package com.midmarsh.spring.service;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import java.util.*;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.midmarsh.spring.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class HelloHandler {

	private List<User> users = new ArrayList<User>();

	public HelloHandler() {
		System.out.println("HelloHandler.<cons>()");
		User user = new User("Bill", 30);
		users.add(user);
		user = new User("Ben", 28);
		users.add(user);
	}

	public Mono<ServerResponse> hello(ServerRequest request) {
		System.out.println("HelloHandler.hello()");
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
				.body(BodyInserters.fromObject("Hello, Spring Webflux!"));
	}

	public Mono<ServerResponse> getUser(ServerRequest request) {
		String name = request.pathVariable("name");
		System.out.println("HelloHandler.getUser(" + name + ")");
		User user = new User(name, 54);
		return ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(user));
	}

	public Mono<ServerResponse> saveUser(ServerRequest request) {
		Mono<User> userMono = request.bodyToMono(User.class);
		System.out.println("HelloHandler.saveUser(" + userMono + ")");
		Mono<Void> response = userMono.doOnNext(user -> {
			System.out.println("User: " + user);
			users.add(user);
			System.out.println("User added to list: " + users);
		}).thenEmpty(Mono.empty());
		return ServerResponse.ok().build(response);
	}

	public Mono<ServerResponse> allUsers(ServerRequest request) {
		System.out.println("HelloHandler.users()");
		Flux<User> allUsers = Flux.fromIterable(users);
		return ServerResponse.ok().contentType(APPLICATION_JSON).body(allUsers, User.class);
	}
	
    public Mono<ServerResponse> delete(ServerRequest request) {
    	String name = request.pathVariable("name");
		System.out.println("HelloHandler.delete(" + name + ")");
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(name));
    }

}
