package com.demospringmvc.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data")
public class DataController {
	
	@RequestMapping("/initData")
	public String initUser(HttpServletRequest request) {
		String result = "This is initData.";
		request.setAttribute("result", result);
		return "data";
	}
	
	@RequestMapping("/qryData")
	public String qryUser(HttpServletRequest request) {
		String result = "This is qryData.";
		request.setAttribute("result", result);
		return "data";
	}
	
	@RequestMapping("/addData")
	public String addUser(String name, String age, HttpServletRequest request) {
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		return "data";
	}
	
}
