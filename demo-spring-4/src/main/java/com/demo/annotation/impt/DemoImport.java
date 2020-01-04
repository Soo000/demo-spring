package com.demo.annotation.impt;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Import 注解
 */
@Configuration
@Import(value = {Dog.class, Pig.class})
public class DemoImport {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(DemoImport.class);
		Dog dog = cxt.getBean(Dog.class);
		System.out.println(dog);
		
		Pig pig = cxt.getBean(Pig.class);
		System.out.println(pig);
		
		cxt.close();
	}
	
}
