package com.demo.annotation.imptselector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Dog.class, Pig.class, MyImportSelector.class})
public class DemoImportSelector {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(DemoImportSelector.class);
		Tiger tiger = cxt.getBean(Tiger.class);
		System.out.println(tiger);
		cxt.close();
	}
	
}
