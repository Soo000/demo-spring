package com.demospring.bean.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.demospring.bean.annotation.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	public void save() {
		System.out.println("UserController.save()");
		userService.save();
	}
	
}
