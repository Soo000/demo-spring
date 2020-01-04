package com.demo.annotation.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否 Linux 系统
 */
public class LinuxCondition implements Condition {

	/**
	 * ConditionContext：判断条件使用的上下文环境
	 * AnnotatedTypeMetadata：标注了@Conditional注解的注释信息
	 * 
	 * 判断是否 linux 系统
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 1. 获取bean工厂
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		// 2. 获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		// 3. 获取当前环境信息
		Environment environment = context.getEnvironment();
		// 4. 获取 Bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		
		String osName = environment.getProperty("os.name");
		if (osName.contains("linux")) {
			return true;
		}
		
		return false;
	}

}
