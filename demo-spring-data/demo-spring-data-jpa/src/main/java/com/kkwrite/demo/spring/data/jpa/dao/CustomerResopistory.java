package com.kkwrite.demo.spring.data.jpa.dao;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

import com.kkwrite.demo.spring.data.jpa.entity.Customer;

@RepositoryDefinition(domainClass = Customer.class, idClass = Integer.class)
public interface CustomerResopistory {

	Customer findById(Integer id);
	
	List<Customer> getByLastNameStartingWith(String lastName);
	
	List<Customer> getByLastNameContaining(String words);
	
	List<Customer> getByIdIn(List<Integer> ids);
	
}
