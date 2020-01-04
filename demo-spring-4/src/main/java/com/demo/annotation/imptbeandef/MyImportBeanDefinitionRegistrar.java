package com.demo.annotation.imptbeandef;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * AnnotationMetadata: 获取@Import注解的值和当前标注@Import注解的类的所有注解信息
	 * BeanDefinitionRegistry: bean注册类。可以调用其 registerBeanDefinition() 方法进行注册；
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		System.out.println(importingClassMetadata);
		
		Boolean hasMouse = registry.containsBeanDefinition("mouse");
		if (!hasMouse) {
			System.out.println("容器中没有 mouse 实例");
			BeanDefinition beanDefinition = new RootBeanDefinition(Mouse.class);
			registry.registerBeanDefinition("mouse", beanDefinition);
			System.out.println("向容器注册 mouse 实例完成");
		}
	}

}
