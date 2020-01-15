package com.demo.spring.lifecycle.initializing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoInitializingBean {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		MyCar myCar = (MyCar) context.getBean("myCar");
		System.out.println("Mycar " + myCar + " has been get.");
		
		context.close();
	}
	
}
