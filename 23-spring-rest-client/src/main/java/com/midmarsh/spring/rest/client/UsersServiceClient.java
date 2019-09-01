package com.midmarsh.spring.rest.client;

import org.springframework.web.client.RestTemplate;

public class UsersServiceClient {
	private RestTemplate restTemplate;
	private String url;

	public UsersServiceClient(RestTemplate restTemplate, String url) {
		this.restTemplate = restTemplate;
		this.url = url;
	}

	public String getUser(String user) {
		return restTemplate.getForObject(url + user, String.class);
	}
}
