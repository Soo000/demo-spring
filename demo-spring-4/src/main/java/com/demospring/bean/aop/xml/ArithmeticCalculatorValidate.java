package com.demospring.bean.aop.xml;

import org.aspectj.lang.JoinPoint;

public class ArithmeticCalculatorValidate {
	
	/**
	 * 定一个方法，用于切面表达式（一般，该方法不用添加代码）
	 * 使用@PointCut声明切入表达式
	 * 后面的其它通知使用方法名作为切入点表达式
	 */
	public void declareJoinPointExpression() {
		
	}

	public void beforeValidate(JoinPoint joinPoint) {
		System.out.println("-- ArithmeticCalculatorValidate.beforeValidate()");
	}
	
	public void afterValidate(JoinPoint joinPoint) {
		System.out.println("-- ArithmeticCalculatorValidate.afterValidate()");
	}
	
}
