package com.demospring.bean.cycle;

public class CycleBean {

	private String brand;
	
	public CycleBean() {
		System.out.println("Cycle bean construction");
	}
	
	public void init() {
		System.out.println("Cycle bean init...");
	}
	
	public void destroy() {
		System.out.println("Cycle bean destroy.");
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
