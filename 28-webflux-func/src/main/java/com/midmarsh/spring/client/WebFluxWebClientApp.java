package com.midmarsh.spring.client;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.midmarsh.spring.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebFluxWebClientApp {

	public static void main(String[] args) throws Exception {
		System.out.println("Set up web client");
		WebClient client = WebClient.create("http://localhost:8080");

		System.out.println("Call a mono get method");
		Mono<User> userMono = client.get().uri("service/user/John").retrieve().bodyToMono(User.class);
		System.out.println(userMono);
		User user = userMono.block(); // blocks waiting for response
		System.out.println("User: " + user);
		// userMono.subscribe(WebFluxWebClientApp::handleResponse); // subscribe returns
		// immediately
		System.out.println("-----------------");

		System.out.println("Call a post method");
		User newUser = new User("Phoebe", 26);
		newUser.setTitle("Dr");
		Mono<User> responseUser = client.post().uri("/service").body(BodyInserters.fromObject(newUser)).retrieve().bodyToMono(User.class);
		System.out.println(responseUser);
		responseUser.subscribe(WebFluxWebClientApp::handleResponse); 
		
		System.out.println("-----------------");
		System.out.println("Call a Flux Get method");
		Flux<User> usersFlux = client.get().uri("/service/users").retrieve().bodyToFlux(User.class);
		System.out.println(usersFlux);
		usersFlux.subscribe(WebFluxWebClientApp::handleResponse); 

		System.out.println("-----------------");
		
		System.out.println("Call a delete method");
		Mono<String> deletedUserMono = client.delete().uri("service/user/Bob").retrieve().bodyToMono(String.class);
		System.out.println("Deleted User Mono" + deletedUserMono);
		deletedUserMono.subscribe(System.out::println);

		// wait for a while for response
		Thread.sleep(1100);
		System.out.println("Press 'Enter' to terminate");
		System.in.read();
		System.out.println("Done");
	}

	private static void handleResponse(User u) {
		System.out.println("Handle Response: " + u);
	}

}
