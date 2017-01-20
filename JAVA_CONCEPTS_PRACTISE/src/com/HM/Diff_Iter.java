package com.HM;

import java.util.HashMap;
import java.util.Map;

public class Diff_Iter {

	public static void main(String[] args) {
		
		Map<Integer,String> hm = new HashMap<Integer, String>();
		hm.put(1, "Test");
		hm.put(2, "Example");
		hm.put(3, "Hashmap");
		
		System.out.println("Iterating only keys :");
		for(Integer key:hm.keySet()){
		
			System.out.println("Key :" + key +" Value :" + hm.get(key) );
			
			
		}
		
		System.out.println("Iterating only values :");
		
		for(String value : hm.values()){
			System.out.println("Only values are : " +value );
			
		}
		
		System.out.println("Iterating Key Value pairs :");
		for(Map.Entry<Integer, String> keyVal : hm.entrySet()){
			System.out.println("Key is :" +keyVal.getKey() + " Value is :" +keyVal.getValue());
			
		}
		
	}
	
	
	void calculate(int a ,int b){
		System.out.println("HEllo void return type");
		
	}
	
	/*int calculate(int a ,int b){
	
		
	}*/
}
