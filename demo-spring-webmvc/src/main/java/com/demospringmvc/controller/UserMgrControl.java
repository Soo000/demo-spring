package com.demospringmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.demospringmvc.pojo.User;

public class UserMgrControl extends MultiActionController {
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("------ list user ------");
		User user = new User();
		user.setName("wangke");
		user.setAge(31);
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("user", user);
		return mav;
	}

	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("add");
		System.out.println("------ add user ------");
		return mav;
	}

	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("------ edit user ------");
		ModelAndView mav = new ModelAndView("edit");
		return mav;
	}

}
