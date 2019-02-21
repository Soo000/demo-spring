package com.demospring.bean.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArithmeticMain {

private static ApplicationContext cxt;
	
	static {
		cxt = new ClassPathXmlApplicationContext("classpath:beans-aop.xml");
	}

	public static void main(String[] args) {

		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) cxt.getBean("arithmeticCalculator");
		int result = -1;
		try {
			result = arithmeticCalculator.add(2, 2);
			//result = arithmeticCalculator.div(10, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
	
}
