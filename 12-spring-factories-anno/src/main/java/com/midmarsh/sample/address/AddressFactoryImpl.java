package com.midmarsh.sample.address;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Import(OtherFactory.class)
public class AddressFactoryImpl {

	@Bean(name="Address")
	public Address getAddress() {
		return new AddressImpl();
	}
	
}
