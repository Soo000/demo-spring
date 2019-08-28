package com.kkwrite.demo.spring.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.kkwrite.demo.spring.jpa.entity.Customer;

@Repository
public class CustomerDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void save(Customer customer) {
		entityManager.persist(customer);
	}
	
}
