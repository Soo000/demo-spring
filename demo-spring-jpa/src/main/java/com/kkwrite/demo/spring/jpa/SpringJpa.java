package com.kkwrite.demo.spring.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJpa {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

}
