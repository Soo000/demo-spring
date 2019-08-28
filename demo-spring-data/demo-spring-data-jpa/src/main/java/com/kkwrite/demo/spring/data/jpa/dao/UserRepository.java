package com.kkwrite.demo.spring.data.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kkwrite.demo.spring.data.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findById(Integer id);
	
	User getByUsername(String username);
	
}
