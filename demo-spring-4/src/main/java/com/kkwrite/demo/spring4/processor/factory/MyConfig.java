package com.kkwrite.demo.spring4.processor.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
		return new MyBeanFactoryPostProcessor();
	}
	
	@Bean
	public MyCar myCar() {
		return new MyCar();
	}
	
}
