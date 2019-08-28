package com.kkwrite.demo.spring.jpa.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kkwrite.demo.spring.jpa.dao.CustomerDao;
import com.kkwrite.demo.spring.jpa.entity.Customer;

@Service
public class CustomerService {

	@Resource(name = "customerDao")
	private CustomerDao customerDao;
	
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
	}
	
}
