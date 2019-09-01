package com.midmarsh.spring.web;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midmarsh.spring.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("service")
public class UserController {
	
	private List<User> users = new ArrayList<User>();

	public UserController() {
		System.out.println("UserController.<cons>()");
		User user = new User("Bill", 30);
		users.add(user);
		user = new User("Ben", 28);
		users.add(user);
	}
	
	@GetMapping
	private String getWelcomeMessage() {
		return "Hello from WebFlux: " + new Date();
	}
	
	@GetMapping(path = "user/{name}")
	public Mono<ResponseEntity<User>> getUser(@PathVariable String name) {
		System.out.println("UserController.getUser(" + name + ")");
		User user = new User(name, 54);
		return Mono.just(new ResponseEntity<>(user, HttpStatus.CREATED));
	}
	
	@PostMapping
    public Mono<ResponseEntity<User>> save(@RequestBody User user) {
		System.out.println("UserController.save(" + user + ")");
		users.add(user);
        return Mono.just(new ResponseEntity<>(user, HttpStatus.CREATED));
    }
	
	@DeleteMapping(path = "user/{name}")
    public Mono<ResponseEntity<String>> delete(@PathVariable("name") String name) {
		System.out.println("UserController.delete(" + name + ")");
        return Mono.just(new ResponseEntity<String>("Deleted", HttpStatus.ACCEPTED));
    }
	
	@GetMapping(path = "users")
	private Flux<User> getAllUsers() {
		System.out.println("UserController.users()");
	    return Flux.fromIterable(users);
	}
	

}
