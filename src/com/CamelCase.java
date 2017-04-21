package com.HR.StringsAlgo;

import java.util.Scanner;

public class CamelCase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String s = in.next();
        int countOfWords=0;
        String[] str= s.split("[A-z]");
       /* for(int i=0;i<s.length();i++){
        	String letter = Character.toString(s.charAt(i));
        	if(letter==letter.toUpperCase()){
        		countOfWords ++;
        		
        	}
        	
        	
        }*/
        System.out.println(str.length);
        System.out.println(countOfWords+1);
	}
	
}
