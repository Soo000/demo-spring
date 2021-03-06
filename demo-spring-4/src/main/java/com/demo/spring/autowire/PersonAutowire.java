package com.demo.spring.autowire;

import com.demo.spring.po.Address;
import com.demo.spring.po.Car;

public class PersonAutowire {
	
	private String name;
	private int age;
	private Car car;
	private Address address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "PersonAutowire [name=" + name + ", age=" + age + ", car=" + car
				+ ", address=" + address + "]";
	}
	
}
