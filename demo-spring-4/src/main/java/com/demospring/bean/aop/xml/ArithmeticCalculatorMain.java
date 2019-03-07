package com.demospring.bean.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArithmeticCalculatorMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:com/demospring/bean/aop/xml/beans-aop-conf.xml");
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) applicationContext.getBean("arithmeticCalculator");
		int result = -1;
		try {
			//arithmeticCalculator.add(2, 2);
			result = arithmeticCalculator.div(2, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("result=" + result);
	}

}
