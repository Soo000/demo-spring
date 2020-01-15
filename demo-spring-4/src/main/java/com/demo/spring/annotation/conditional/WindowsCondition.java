package com.demo.spring.annotation.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否 Windows 系统
 */
public class WindowsCondition implements Condition {

	/**
	 * ConditionContext：判断条件使用的上下文环境
	 * AnnotatedTypeMetadata：标注了@Conditional注解的注释信息
	 * 
	 * 判断是否 linux 系统
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 获取当前环境信息
		Environment environment = context.getEnvironment();
		String osName = environment.getProperty("os.name");
		if (osName.contains("Windows")) {
			return true;
		}
		
		return false;
	}

}
