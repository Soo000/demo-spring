package com.demo.spring.annotation.imptbeandef;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Dog.class, MyImportBeanDefinitionRegistrar.class})
public class DemoMyImptBeanDef {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(DemoMyImptBeanDef.class);
		Mouse mouse = cxt.getBean(Mouse.class);
		System.out.println(mouse);
		cxt.close();
	}
	
}
