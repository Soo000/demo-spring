package com.demospringmvc.controller.annotation;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demospringmvc.pojo.User;

@Controller
@RequestMapping("/json")
public class JsonController {
	
	@RequestMapping("/initJson")
	public String initJson() {
		System.out.println("initJson");
		return "json";
	}
	
	@RequestMapping("/addJson")
	public void addJson(User user, HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			System.out.println("user=" + user.getName() + ", age=" + user.getAge());
			String strJsn = "{name: '" + user.getName() + "', age: '" + user.getAge() + "'}";
			response.getWriter().write(strJsn);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
