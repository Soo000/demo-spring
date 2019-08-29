package com.kkwrite.demo.spring.data.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.kkwrite.demo.spring.data.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	User findById(Integer id);
	
	User getByUsername(String username);
	
}
