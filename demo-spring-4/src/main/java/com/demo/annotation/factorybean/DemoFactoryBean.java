package com.demo.annotation.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoFactoryBean {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(DemoFactoryBean.class);
		
		Object bean = cxt.getBean("birdFactoryBean");
		System.out.println("bean 的类型是 " + bean.getClass());
		
		Object factoryBean = cxt.getBean("&birdFactoryBean");
		System.out.println("获取工厂bean本身 " + factoryBean.getClass());
		
		cxt.close();
	}
	
	@Bean
	public BirdFactoryBean birdFactoryBean() {
		return new BirdFactoryBean();
	}
	
}
