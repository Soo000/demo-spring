package com.kkwrite.demo.spring.data.jpa.dao;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kkwrite.demo.spring.data.jpa.entity.Customer;

public class CustomerRepositoryTest {

	ApplicationContext cxt;
	
	CustomerResopistory customerResopistory;
	
	@Before
	public void before() {
		cxt = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		customerResopistory = (CustomerResopistory) cxt.getBean(CustomerResopistory.class);
	}
	
	@Test
	public void getById() {
		 Customer customer = customerResopistory.findById(1);
		 System.out.println(customer);
	}
	
	@Test
	public void getByLastNameStartingWith() {
		List<Customer> customers = customerResopistory.getByLastNameStartingWith("王");
		customers.forEach(c -> {
			System.out.println(c);
		});
	}
	
	@Test
	public void getByLastNameContaining() {
		List<Customer> customers = customerResopistory.getByLastNameContaining("王");
		customers.forEach(c -> {
			System.out.println(c);
		});
	}
	
	@Test
	public void getByIdIn() {
		List<Customer> customers = customerResopistory.getByIdIn(Arrays.asList(1, 2, 3));
		customers.forEach(c -> {
			System.out.println(c);
		});
	}
	
}
