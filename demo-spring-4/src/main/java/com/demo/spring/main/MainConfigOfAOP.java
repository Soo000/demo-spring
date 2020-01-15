package com.demo.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/** 
 * 类说明 
 *
 * @author Soosky Wang
 * @date 2018年10月6日 上午7:45:38 
 * @version 1.0.0
 */
@EnableAspectJAutoProxy
public class MainConfigOfAOP {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext();
		Object o = cxt.getBean("A");
		System.out.println(o);
		cxt.close();
	}
	
}
