package com.demo.spring.processor.myprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public MyCar myCar() {
		return new MyCar();
	}
	
	@Bean
	public MyBeanProcessor myBeanProcessor() {
		return new MyBeanProcessor();
	}
	
}
