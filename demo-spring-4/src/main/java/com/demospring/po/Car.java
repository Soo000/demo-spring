package com.demospring.po;

public class Car {
	
	private String brand;
	private String corp;
	private int maxSpeed;
	
	public Car() {
	}
	
	public Car(String brand, String corp) {
		this.brand = brand;
		this.corp = corp;
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
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", corp=" + corp + ", maxSpeed="
				+ maxSpeed + "]";
	}
}
