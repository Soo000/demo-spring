package com.demo.spring.aop.aspects;

import com.demo.spring.aop.myannotation.MyAnnotation;

/**
 * 计算业务逻辑类
 */
public class MathCalculator {
	
	@MyAnnotation("myHandler")
	public int add(int a, int b) {
		return a + b;
	}
	
}
