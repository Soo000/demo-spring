package com.demospring.bean.annotation.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public void save() {
		System.out.println("UserService.save()");
	}
	
}
