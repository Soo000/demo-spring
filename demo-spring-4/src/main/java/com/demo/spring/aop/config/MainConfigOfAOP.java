package com.demo.spring.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.demo.spring.aop.aspects.LogAspects;
import com.demo.spring.aop.aspects.MathCalculator;

@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAOP {

	@Bean
	public MathCalculator calculator() {
		return new MathCalculator();
	}
	
	@Bean
	public LogAspects logAspects() {
		return new LogAspects();
	}
	
}
