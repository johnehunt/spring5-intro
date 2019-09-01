package com.midmarsh.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration("Main Aspect Anno Example Config")
@EnableAspectJAutoProxy
@ComponentScan(
		basePackages = { "com.midmarsh.spring.beans, com.midmarsh.sample.pojo" })
public class AppConfig {

}
