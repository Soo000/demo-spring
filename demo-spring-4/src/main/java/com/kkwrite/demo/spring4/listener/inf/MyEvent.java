package com.kkwrite.demo.spring4.listener.inf;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件 
 *
 */
public class MyEvent extends ApplicationEvent {
	
	private static final long serialVersionUID = 1L;
	
	public MyEvent(Object source) {
		super(source);
		System.out.println("MyEvent Constructor");
	}

}
