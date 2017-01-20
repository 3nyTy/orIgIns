package com.HM;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class testHashMap {
public static void main(String[] args) {
	Map<Dog,Integer> hm=new HashMap<Dog,Integer>();
	hm.put(new Dog("White"), 5);
	hm.put(new Dog("Black"), 7);
	hm.put(new Dog("Brown"), 20);
	hm.put(new Dog("White"), 22);
	System.out.println(hm.size());
	
	for(Entry<Dog,Integer> entry:hm.entrySet()){
		System.out.println(entry.getKey() +"--" +entry.getValue());
	}
}
}


class Dog{
	
	String color;
	
	public Dog(String color){
		this.color=color;
	}
	
	public String toString(){
		return color + " dog";
		
		
	}
	public int hashcode(){
		return color.length()+1;
		
	}
	public boolean equals(Object o){
		return ((Dog)o).color.equals(this.color);
			
	}
	
}
