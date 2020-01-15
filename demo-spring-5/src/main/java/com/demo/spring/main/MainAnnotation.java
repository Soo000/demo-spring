package com.demo.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainAnnotation {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(MainAnnotation.class);
		String[] beanDefinitionNames = cxt.getBeanDefinitionNames();
		for (String beanName: beanDefinitionNames) {
			System.out.println(beanName);
		}
		cxt.close();
	}
	
}
