package com.demospringmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MultiController extends MultiActionController {

	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("add");
		ModelAndView mav = new ModelAndView("paramMethod");
		mav.addObject("method", "add");
		return mav;
	}
	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("update");
		ModelAndView mav = new ModelAndView("paramMethod");
		mav.addObject("method", "update");
		return mav;
	}
	
	public ModelAndView img(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("img");
		ModelAndView mav = new ModelAndView("/staticFile");
		mav.addObject("method", "staticFile");
		return mav;
	}
	
}
