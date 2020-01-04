package com.demo.annotation.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class BirdFactoryBean implements FactoryBean<Bird> {

	/**
	 * 返回对象加入到容器
	 */
	@Override
	public Bird getObject() throws Exception {
		return new Bird();
	}

	@Override
	public Class<?> getObjectType() {
		return Bird.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
