package com.demo.spring.processor.myprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanProcessorMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		MyCar myCar = context.getBean(MyCar.class);
		context.close();
	}
	
}
