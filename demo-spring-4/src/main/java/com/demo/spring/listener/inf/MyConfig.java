package com.demo.spring.listener.inf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	public MyApplicationListener myListener() {
		return new MyApplicationListener();
	}
}
