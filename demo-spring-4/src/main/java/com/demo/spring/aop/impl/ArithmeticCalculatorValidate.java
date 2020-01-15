package com.demo.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ArithmeticCalculatorValidate {
	
	/**
	 * 定一个方法，用于切面表达式（一般，该方法不用添加代码）
	 * 使用@PointCut声明切入表达式
	 * 后面的其它通知使用方法名作为切入点表达式
	 */
	@Pointcut("execution(* com.demospring.bean.aop.impl.ArithmeticCalculatorImpl.*(..))")
	public void declareJoinPointExpression() {
		
	}

	@Before("declareJoinPointExpression()")
	public void beforeValidate(JoinPoint joinPoint) {
		System.out.println("-- ArithmeticCalculatorValidate.beforeValidate()");
	}
	
	@After("declareJoinPointExpression()")
	public void afterValidate(JoinPoint joinPoint) {
		System.out.println("-- ArithmeticCalculatorValidate.afterValidate()");
	}
	
}
