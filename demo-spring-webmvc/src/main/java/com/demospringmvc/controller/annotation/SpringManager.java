package com.demospringmvc.controller.annotation;

import org.springframework.stereotype.Component;

@Component("springManager")
public class SpringManager implements ISpring {

	@Override
	public String get() {
		System.out.println("------ Spring Manager ------");
		return "SpringManger";
	}

}
