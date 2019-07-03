package com.kkwrite.demo.spring4.listener.inf;

import org.springframework.context.ApplicationListener;

/**
 * 自定义 ApplicationListener 监听器，监听 ApplicationEvent（或其子类事件）
 * 事件到达，触发 onApplicationEvent() 函数
 */
public class MyApplicationListener implements ApplicationListener<MyEvent> {

	@Override
	public void onApplicationEvent(MyEvent event) {
		System.out.println("收到事件 event = " + event);
	}

}
