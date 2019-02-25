package com.kkwrite.demo.spring4.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kkwrite.demo.spring4.aop.aspects.MathCalculator;
import com.kkwrite.demo.spring4.aop.config.MainConfigOfAOP;

public class MainAopTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		MathCalculator calculate = (MathCalculator) applicationContext.getBean(MathCalculator.class);
		int result = calculate.add(1, 2);
		System.out.println("result = " + result);
	}
	
}
