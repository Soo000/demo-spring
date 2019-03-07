package com.demospring.bean.factory;

import java.util.HashMap;
import java.util.Map;

import com.demospring.po.Car;

/**
 * 静态工厂方法
 * @author Administrator
 *
 */
public class StaticCarFactory {

	private static Map<String, Car> cars = new HashMap<String, Car>();
	
	static {
		Car car0 = new Car("langyi", "上海");
		Car car1 = new Car("suteng", "一汽");
		
		cars.put("langyi", car0);
		cars.put("suteng", car1);
	}
	
	public static Car getCar(String name) {		
		return cars.get(name);
	}
	
}
