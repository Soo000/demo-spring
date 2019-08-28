package com.kkwrite.demo.spring.data.jpa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkwrite.demo.spring.data.jpa.dao.CustomerResopistory;

@Service
public class CustomerService {

	@Autowired
	private CustomerResopistory customerResopistory;
	
	@Transactional
	public int updateLastName(String lastName, Integer id) {
		return customerResopistory.updateLastName(lastName, id);
	}
	
}
