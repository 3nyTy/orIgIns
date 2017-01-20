package com.DP.ObsrvrPttrn;

public class CurrentConditionsDisplay implements DisplayElement, Observer {
	
	private float temp;
	private float humidity;
	private Subject weatherObj;
	
	
	public CurrentConditionsDisplay(Subject weatherObj){
		this.weatherObj=weatherObj;
		weatherObj.registerObserver(this);
		
		
	}
	

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp=temp;
		this.humidity=humidity;
		display();

	}

	@Override
	public void display() {
		System.out.println("Current conditions : " +temp +" F degres and humidity is : "+humidity);

	}

}
