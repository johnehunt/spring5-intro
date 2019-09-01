package com.midmarsh.spring.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig {
	
	@Bean
	public MessageService myMessageService() {
		return new DefaultMessageService("Hello");
	}

	@Bean(name = "CalculationService")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public CalculationService calcService() {
		return new CalculationServiceImpl();
	}
}
