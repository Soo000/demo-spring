package com.kkwrite.demo.spring4.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demospring.bean.cycle.CycleBean;

@Configuration
public class MainAnnotationConfig {

	@Bean
	public CycleBean cycleBean() {
		return new CycleBean();
	}
	
}
