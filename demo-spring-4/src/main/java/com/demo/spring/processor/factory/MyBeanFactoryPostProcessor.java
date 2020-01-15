package com.demo.spring.processor.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("Start| Bean 的定义信息已经被加载，但是还没有初始化");
		int count = beanFactory.getBeanDefinitionCount();
		System.out.println("count = " + count);
		String[] beanNames = beanFactory.getBeanDefinitionNames();
		for (String beanName: beanNames) {
			System.out.println("beanName: " + beanName);
		}
		System.out.println("End| Bean 的定义信息已经被加载，但是还没有初始化");
	}

}
