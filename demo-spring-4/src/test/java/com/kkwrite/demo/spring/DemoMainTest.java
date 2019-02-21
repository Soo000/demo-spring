package com.kkwrite.demo.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demospring.config.MySpringConfig;

/** 
 * 类说明 
 *
 * @author Soosky Wang
 * @date 2018年10月4日 上午7:40:09 
 * @version 1.0.0
 */
public class DemoMainTest {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MySpringConfig.class);
		System.out.println(applicationContext);
	}
	
	@Test
	@Qualifier
	public void test02() {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(MySpringConfig.class);
		String[] definitionNames = cxt.getBeanDefinitionNames();
		for (String name: definitionNames) {
			System.out.println("Bean definition: " + name);
		}
		
		Object o = cxt.getBean("person");
		Object o2 = cxt.getBean("person");
		
		System.out.println(o == o2);
	}
	
}
