package com.midmarsh.spring.service.hello;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midmarsh.spring.domain.User;

@RestController
@RequestMapping("service")
public class HelloController {

	@GetMapping("welcome")
    public String index() {
        return "Hello from Spring Boot: " + new Date();
    }
	
	@GetMapping("user/{name}")
	public User getUser(@PathVariable String name) {
		System.out.println("UserController.getUser("+ name+ ")");
		User user = new User(name, 54);
		return user;
	}
}
