package com.kkwrite.demo.spring.data.jpa.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kkwrite.demo.spring.data.jpa.entity.User;

public class UserRepositoryTest {

	ApplicationContext cxt;
	
	UserRepository userRepository;
	
	@Before
	public void before() {
		cxt = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		userRepository = (UserRepository) cxt.getBean(UserRepository.class);
	}
	
	@Test
	public void getByUsername() {
		 User user = userRepository.getByUsername("测试用户");
		 System.out.println(user);
	}
	
}
