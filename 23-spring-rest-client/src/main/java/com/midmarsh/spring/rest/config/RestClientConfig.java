package com.midmarsh.spring.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.midmarsh.spring.rest.client.UsersServiceClient;

@Configuration
@ComponentScan(basePackages = "com.midmarsh.spring.rest")
public class RestClientConfig {

	@Bean("userServiceClient")
	public UsersServiceClient getUsersServiceClient() {
		return new UsersServiceClient(new RestTemplate(), "http://localhost:8080/simple/service/users/user/");
	}

}
