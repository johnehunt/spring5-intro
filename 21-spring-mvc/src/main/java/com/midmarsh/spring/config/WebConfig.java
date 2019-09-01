package com.midmarsh.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.midmarsh.spring.mvc")
public class WebConfig implements WebMvcConfigurer {
	
	@Bean(name = "jspViewResolver")
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		System.out.println("WebConfig.getInternalResourceViewResolver()");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
