package com.DP.ObsrvrPttrn;

import java.util.ArrayList;

public class WeatherSubject implements Subject {
	
	private ArrayList observers;
	private  float temp;
	private float humidity;
	private float pressure;
	
	public WeatherSubject(){
		observers = new ArrayList();
		
		
	}

	@Override
	public void registerObserver(Observer o) {
		
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i>=0){
			observers.remove(i);
		}

	}

	@Override
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++){
			Observer obs=(Observer) observers.get(i);
			obs.update(temp, humidity, pressure);
			
			
		}
		
		
	}

	public void measurementsChanged(){
		
		notifyObservers();
	}
	public void setMeasurements(float temp,float humidity,float pressure){
		this.temp=temp;
		this.humidity=humidity;
		this.pressure=pressure;
		measurementsChanged();
		
	}
	
}
