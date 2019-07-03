package com.kkwrite.demo.spring4.processor.myprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanProcessorMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		MyCar myCar = context.getBean(MyCar.class);
		context.close();
	}
	
}
