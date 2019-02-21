package com.demospringmvc.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demospringmvc.pojo.User;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@RequestMapping("/initUser")
	public ModelAndView initUser() {
		String result = "This is initUser.";
		ModelAndView mav = new ModelAndView("annotation", "result", result);
		return mav;
	}
	
	@RequestMapping("/qryUser")
	public String qryUser(HttpServletRequest request) {
		String result = "This is qryUser.";
		request.setAttribute("result", result);
		return "annotation";
	}

	@RequestMapping(value="/addUser")
	public String addUser(User user, HttpServletRequest request) {
		request.setAttribute("user", user);
		return "add";
	}
	
	@RequestMapping(value="/delUser", method=RequestMethod.GET)
	public ModelAndView delUser() {
		String result = "This is delUser.";
		ModelAndView mav = new ModelAndView("annotation", "result", result);
		return mav;
	}
}
