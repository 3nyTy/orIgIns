package com.DP.Decorator;

public abstract class Beverage {

	String description="Sample";
	
	public String getDescription(){
		return description;
	}
	
	public abstract double cost();
	
}
