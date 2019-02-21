package com.demospringmvc.controller.annotation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class SpringController {

	@Resource(name="springManager")
	private ISpring springManager;
	
	@RequestMapping("/spring/get")
	public String get(HttpServletRequest request) {
		// ע�ⷽʽֱ����
		String result = springManager.get();
		System.out.println(result);
		
		// Spring ��������
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		// SpringMvc ��������
		WebApplicationContext webApplicationContext2 = RequestContextUtils.getWebApplicationContext(request);
		
		// �� Spring �������л�ȡ bean
		ISpring springManager2 = (ISpring) webApplicationContext.getBean("springManager");
		result = springManager2.get();
		System.out.println(result);
		
		// �� SpringMvc �������л�ȡ bean
		ISpring springManager3 = (ISpring) webApplicationContext2.getBean("springManager");
		result = springManager3.get();
		System.out.println(result);
		
		return "springspringmvc/success";
	}
	
}
