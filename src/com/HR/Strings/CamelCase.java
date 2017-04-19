package com.HR.Strings;

import java.util.Scanner;

public class CamelCase {
	

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String s = in.next();
	        System.out.println(s.length()-s.replaceAll("[A-Z]","").length()+1);
	        
	      /*  int count=0;
	        for(int i=0;i<s.length();i++){
	        	String letter = Character.toString(s.charAt(i));
	        	if(letter==letter.toUpperCase()){
	        		count++;
	        	}
	        	
	        }
	        System.out.println(count+1);	 */  
}
}
