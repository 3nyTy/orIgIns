package com.HM;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMap_ex {

	public static void main(String[] args) {
		
		Map<String,String> treemap=new TreeMap<String,String>();
		treemap.put("Hey", "Gowri");
		treemap.put("How", "Are u?");
		treemap.put("What", "Are u dng");
		
		for(String s:treemap.keySet()){
			
			System.out.println("Keys are : " +s +"-- Values are : " +treemap.get(s));
		}
		
		Map<String,String> hashmap=new HashMap<String,String>();
		hashmap.put("Hey", "Gowri1");
		hashmap.put("How", "Are u1?");
		hashmap.put("What", "Are u dng1");
		
		for(String s:hashmap.keySet()){
			
			System.out.println("Keys are : " +s +"-- Values are : " +hashmap.get(s));
		}
		
	}
	
	
	
}
