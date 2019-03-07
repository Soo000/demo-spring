package com.demospring.bean.annotation;

import org.springframework.stereotype.Component;

@Component
public class MyComponnet {

	public MyComponnet() {
		System.out.println("Constructor MyComponent");
	}
}
