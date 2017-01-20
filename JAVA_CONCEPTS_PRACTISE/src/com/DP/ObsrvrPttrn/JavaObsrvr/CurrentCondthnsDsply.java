package com.DP.ObsrvrPttrn.JavaObsrvr;

import java.util.Observable;
import java.util.Observer;

import com.DP.ObsrvrPttrn.DisplayElement;

public class CurrentCondthnsDsply implements Observer, DisplayElement {
	Observable observable;
	private float temp;private float humidity;
	
	public CurrentCondthnsDsply(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
		}
	@Override
	public void display() {
		System.out.println("Current conditions : " +temp +" F degres and humidity is : "+humidity);

	}

	@Override
	public void update(Observable obs, Object arg) {
		if(obs instanceof WeatherSubject_O ){
			WeatherSubject_O wd=(WeatherSubject_O)obs;
			this.temp=wd.getTemperature();
			this.humidity=wd.getHumidity();
			display();
		}
	
	}

}
