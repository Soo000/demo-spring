package com.demospring.bean.factory;

import org.springframework.beans.factory.FactoryBean;

import com.demospring.po.Car;

public class CarFactoryBean implements FactoryBean<Car> {

	private String brand;
	private String corp;
	
	@Override
	public Car getObject() throws Exception {
		Car car = new Car(brand, corp);
		return car;
	}

	@Override
	public Class<Car> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCorp() {
		return corp;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}

}
