package com.kkwrite.demo.spring4.lifecycle.initializing;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MyCar implements InitializingBean, DisposableBean {
	
	private String name = "myCar";
	
	public MyCar() {
		System.out.println("MyCar Constructor is invoked !");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("MyCar#afterPropertiesSet() is invoked !");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("MyCar#destroy() is invoked !");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
