/*****
 * The emp manager relation is as below:
 * Emp Manager
 * 1   2
 * 2  3
 * 4  5
 * 3  6
 * For an employee print the hierarchy eg :for 6 it is 1-->2-->3-->6
 */
  package com.MS;

import java.util.HashMap;

public class MapImpEx {
public static void main(String[] args) {
	
	HashMap<Integer,Integer> empMangrPair = new HashMap<Integer,Integer>();
	empMangrPair.put(1, 2);
	empMangrPair.put(2, 3);
	empMangrPair.put(4, 5);
	empMangrPair.put(3, 6);
	int emp=1;
	StringBuilder out=new StringBuilder("");
	while(empMangrPair.containsKey(emp)){
		
		out.append(emp).append(new StringBuilder("-->"));
		emp=empMangrPair.get(emp);
		
	}
	System.out.println(out.append(6).toString());
}
	
}
