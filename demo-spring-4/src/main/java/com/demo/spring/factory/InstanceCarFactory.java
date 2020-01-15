package com.demo.spring.factory;

import java.util.HashMap;
import java.util.Map;

import com.demo.spring.po.Car;

public class InstanceCarFactory {

	private Map<String, Car> cars = new HashMap<String, Car>();
	
	public InstanceCarFactory() {
		cars.put("langyi", new Car("langyi", "上海"));
		cars.put("suteng", new Car("suteng", "一汽"));
	}
	
	public Car getCar(String name) {
		return cars.get(name);
	}
	
}
