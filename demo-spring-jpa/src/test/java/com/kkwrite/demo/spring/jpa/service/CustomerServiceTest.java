package com.kkwrite.demo.spring.jpa.service;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kkwrite.demo.spring.jpa.entity.Customer;

public class CustomerServiceTest {

	ApplicationContext cxt = null;
	CustomerService customerService = null;
	
	@Before
	public void before() {
		cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		customerService = (CustomerService) cxt.getBean(CustomerService.class);
	}
	
	@Test
	public void save() {
		Customer customer = new Customer();
		customer.setLastName("1111");
		customer.setIsDeleted(0);
		customer.setGmtCreate(new Date());
		customer.setGmtModified(new Date());
		
		customerService.saveCustomer(customer);
	}
	
}
