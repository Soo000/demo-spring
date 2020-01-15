package com.demo.spring.aop.aspects;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import com.demo.spring.aop.myannotation.MyAnnotation;
import com.demo.spring.aop.myhandler.MyHandler;

@Aspect
public class LogAspects implements BeanFactoryAware {
	
	BeanFactory beanFacotry;

	/**
	 * execution表达式写不对会引起@bean注解注入LogAspects问题
	 */
	@Pointcut("execution(public int com.demo.spring.aop.aspects.MathCalculator.*(..))")
	public void logCut() {
	}

	@Before("logCut()")
	public void logBefore(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		Annotation[] annotations = method.getAnnotations();
		Optional.ofNullable(annotations)
				.ifPresent(annos -> {
					MyAnnotation myAnnotation = (MyAnnotation) annos[0];
					String value = myAnnotation.value();
					System.out.println(value);
					
					MyHandler myHandler = (MyHandler) beanFacotry.getBean(value);
					myHandler.hello();
					//throw new RuntimeException("非法的参数错误");
				});
		
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("方法" + methodName + "调用之前, 参数列表：" + args);
	}

	/**
	 * 目前写的有问题
	 * @param joinPoint
	 */
	/*@Around("logCut()")
	public void logAround(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("方法" + methodName + "环绕, 参数列表：" + args);
	}*/

	@After("com.demo.spring.aop.aspects.LogAspects.logCut()")
	public void logEnd(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("方法" + methodName + "调用之后, 参数列表：" + args);
	}

	@AfterReturning(value = "logCut()", returning = "result")
	public void logReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("方法" + methodName + "调用返回, 参数列表：" + args);
	}

	@AfterThrowing(value = "logCut()", throwing = "e")
	public void logThrowing(JoinPoint joinPoint, Exception e) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("方法" + methodName + "调用异常, 参数列表：" + args);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFacotry = beanFactory;
	}

}
