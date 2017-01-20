package com.DP.ObsrvrPttrn;

import com.DP.ObsrvrPttrn.JavaObsrvr.CurrentCondthnsDsply;
import com.DP.ObsrvrPttrn.JavaObsrvr.WeatherSubject_O;

public class WeatherStation {
public static void main(String[] args) {
	
	WeatherSubject weatherdata=new WeatherSubject();
	CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherdata);
	weatherdata.setMeasurements(80, 65, 30.4f);
	weatherdata.setMeasurements(82, 70, 29.2f);
	weatherdata.setMeasurements(78, 90, 29.2f);
	
	//CurrentCondthnsDsply cd= new CurrentCondthnsDsply();
	System.out.println("Through JAva Observer and observable pattern");
	WeatherSubject_O weatherobj=new WeatherSubject_O();
	CurrentCondthnsDsply cd= new CurrentCondthnsDsply(weatherobj);
	weatherobj.setMeasurements(99, 99, 30.4f);
	
}
	
	
}
