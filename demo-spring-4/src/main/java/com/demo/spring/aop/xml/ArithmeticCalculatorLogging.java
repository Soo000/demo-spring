package com.demo.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ArithmeticCalculatorLogging {

	public void beforeMethod(JoinPoint joinPoint ) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("-- Before execute mehtod: " + methodName + " args: " + args);
	}
	
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("-- After execute mehtod: " + methodName + " args: " + args);
	}
	
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("-- The method " + methodName + " ends width return " + result);
	}
	
	/**
	 * 异常通知
	 * @param joinPoint
	 * @param ex
	 */
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("@@ The method " + methodName + " occurs exception " + ex);
	}
	
	/**
	 * 环绕通知
	 * 类似于动态代理的全过程：ProceedingJoinPoint 决定是否执行执行目标方法
	 * 环绕通知必须有返回值
	 * @param proceedingJoinPoint
	 */
	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
		Object result = null;
		String methodName = proceedingJoinPoint.getSignature().getName();
		
		// 执行目标方法
		try {
			// 前置通知
			System.out.println("-- The method " + methodName + " begin with " + Arrays.asList(proceedingJoinPoint.getArgs()));
			result = proceedingJoinPoint.proceed();
			// 返回通知
			System.out.println("-- The method end with " + result);
		} catch (Throwable e) {
			// 异常通知
			System.out.println("-- The method occurs exception." );
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		// 后置通知
		System.out.println("-- The method " + methodName + " ends." );
		return result;
	}
}
