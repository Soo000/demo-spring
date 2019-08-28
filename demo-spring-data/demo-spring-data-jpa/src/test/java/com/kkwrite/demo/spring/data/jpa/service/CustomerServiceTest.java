package com.kkwrite.demo.spring.data.jpa.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerServiceTest {

	ApplicationContext cxt;
	
	CustomerService customerService;
	
	@Before
	public void before() {
		cxt = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		customerService = (CustomerService) cxt.getBean(CustomerService.class);
	}
	
	/**
	 * @Query与@Modifying 这两个annotation一起声明，可定义个性化更新操作。 
	 *  自定义JPQL支持update和delete操作，同时必须使用@Modifying进行修饰，
	 *   以通知这是一个update或delete操作，同时update或delete操作必须有事务。但不支持insert操作。
	 * @throws Exception
	 */
	@Test
	public void updateLastName() throws Exception {
		int count = customerService.updateLastName("222", 1);
		System.out.println(count);
	}
}
