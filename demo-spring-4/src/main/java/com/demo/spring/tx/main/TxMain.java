package com.demo.spring.tx.main;

import java.util.Arrays;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.tx.config.TxConfig;
import com.demo.spring.tx.dao.UserDao;
import com.demo.spring.tx.entity.User;

public class TxMain {
	
	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(TxConfig.class);
		String[] beanNames = cxt.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanNames));
		
		UserDao userDao = (UserDao) cxt.getBean("userDao");
		User user = new User("soosky7");
		user.setCompanyId(1L);
		user.setPassword("123456");
		user.setVisitorNum("1");
		user.setEmail("soosky@163.com");
		user.setDeleted((short) 0);
		user.setGmtCreate(new Date());
		user.setGmtModified(new Date());
		userDao.save(user);

	}
	
}
