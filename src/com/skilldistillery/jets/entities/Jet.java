package com.skilldistillery.jets.entities;

public class Jet {
	private  String model;
	private double speed;
	private int range;
	private long price;
	
	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	public void fly() {
	System.out.println("super class fly()");
	}
	
	public double getSpeed() {
		return this.speed;
	}

	@Override
	public  String toString() {
		return "[model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]"+"\n";
	}
	
	public String getModel() {
		return this.model;
	} 
	
	public int getRange() {
		return this.range;
	}
	
	public long getPrice() {
		return this.price;
	}

}
