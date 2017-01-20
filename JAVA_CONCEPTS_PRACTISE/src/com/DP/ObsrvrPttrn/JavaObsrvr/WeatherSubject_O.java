package com.DP.ObsrvrPttrn.JavaObsrvr;

import java.util.Observable;

public class WeatherSubject_O extends Observable{
	
	private float temperature;
	private float humidity;
	private float pressure;
	public WeatherSubject_O() { };
	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	private void measurementsChanged() {
		setChanged();
		notifyObservers();
		
	}
	
	public float getTemperature() {
		return temperature;
		}
		public float getHumidity() {
		return humidity;
		}
		public float getPressure() {
		return pressure;
		}
	

}
