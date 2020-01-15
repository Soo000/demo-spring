package com.demo.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @author Wang Ke
 * @since 2019.02.20
 */
public class MainAnnotation {

	private static ApplicationContext cxt;

	public static void main(String[] args) {
		cxt = new AnnotationConfigApplicationContext(MainAnnotationConfig.class);
		
		String[] beans = cxt.getBeanDefinitionNames();
		for (String bean: beans) {
			System.out.println("Bean " + bean);
		}
	}
	
}
