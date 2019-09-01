package com.midmarsh.spring.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.midmarsh.spring.beans")
public class AppConfig  { }
