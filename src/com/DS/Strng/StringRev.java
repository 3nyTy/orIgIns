package com.DS.Strng;

import java.util.Arrays;

public class StringRev {
public static void main(String[] args) {
	String str="Gowri";
	int end = str.length()-1;
	int start =0 ;
	char[] c = str.toCharArray();
	for(int i=0,j=str.length()-1;i<j;i++,j--){
		c[i] ^= c[j] ;
		c[i] ^= (c[j] ^= c[i] );
		
	}
	
	System.out.println(Arrays.toString(c));
}
}
