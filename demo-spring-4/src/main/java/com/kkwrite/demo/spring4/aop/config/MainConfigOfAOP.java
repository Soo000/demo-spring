package com.kkwrite.demo.spring4.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.kkwrite.demo.spring4.aop.aspects.LogAspects;
import com.kkwrite.demo.spring4.aop.aspects.MathCalculator;

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
