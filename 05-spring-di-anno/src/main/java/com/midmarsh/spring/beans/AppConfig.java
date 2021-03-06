package com.midmarsh.spring.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;

@Configuration
@ComponentScan
public class AppConfig {
	
	@Bean
    public DateFormatter dateFormatter() {
        return new DateFormatter("YYYY-MM-dd");
    }

}
