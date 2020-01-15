package com.demo.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.aop.aspects.MathCalculator;
import com.demo.spring.aop.config.MainConfigOfAOP;

public class MainAopTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		MathCalculator calculate = (MathCalculator) applicationContext.getBean(MathCalculator.class);
		int result = calculate.add(1, 2);
		System.out.println("result = " + result);
	}
	
}
