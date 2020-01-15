package com.demo.spring.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.spring.cycle.CycleBean;

@Configuration
public class MainAnnotationConfig {

	@Bean
	public CycleBean cycleBean() {
		return new CycleBean();
	}
	
}
