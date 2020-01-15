package com.demo.spring.listener.inf;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyListenerMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		
		context.publishEvent(new MyEvent("aaa"));
		
		context.close();
	}
	
}
