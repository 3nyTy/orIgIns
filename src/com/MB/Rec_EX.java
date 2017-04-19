package com.MB;

public class Rec_EX {
public static void main(String[] args) {
	
	new Rec().getValue(6);
	
}
}

class Rec{
	
	public int getValue(int num){
		
		if(num > 30) return num;
		
		return num;
		
	}
	
	
}