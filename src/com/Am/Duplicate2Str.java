package com.Am;

import java.util.HashMap;
import java.util.Map;

///unique chars in 2 strings
public class Duplicate2Str {
public static void main(String[] args) {
	
	int[] a={1,3,0,3,4,0,8,9,0,0};
	a[2]=3;
	/*System.out.println("length is : "+a.length );
	for(int i=0;i<a.length;i++){
		
	System.out.println(a[i]);
	}
*/
	HashMap<String,Integer> hm = new HashMap<String,Integer>();
	hm.put(null, 10);
	hm.put(null, 20);
	hm.put(null, null);
	/*List<? extends Exception>
	List<>
	List<?>*/
	
	for(Map.Entry<String,Integer> mpo:hm.entrySet()){
		System.out.println(mpo.getKey() + " , " +mpo.getValue());
	}
	
	
}
}
