package com.demospringmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorld implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ModelAndView mav = new ModelAndView("hello.jsp");
		ModelAndView mav = new ModelAndView("hello");
        mav.addObject("message", "Hello World!");
        
        // ´« Map Öµ
        Map<Object, Object> mapOne = new HashMap<Object, Object>();
        mapOne.put("id", "001");
        mapOne.put("name", "wangke");
        
        mav.addObject("mapOne", mapOne);
        return mav;
	}

}
