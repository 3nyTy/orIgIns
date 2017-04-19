package com.infrr;

import java.util.Arrays;
import java.util.Scanner;

/***reversing vowels in string***/
public class VowelsReverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String vowelStr = "aeiouAEIOU";
	    int l=0;int h=str.length()-1;char[] ch = str.toCharArray();
	    while(h>l){
	    	if(!(vowelStr.contains(String.valueOf(str.charAt(l))))){
	    		l++;
	    		continue;
	    	}
	    	if(!(vowelStr.contains(String.valueOf(str.charAt(h))))){
	    		h--;
	    		continue;
	    	}
	    	swap(ch,l,h);
	    	l++;h--;
	    }
		
	System.out.println(Arrays.toString(ch)+" " + String.valueOf(ch));
		
		
		
	}

	private static void swap(char[] ch, int l, int h) {
		char temp=ch[l];
		ch[l] = ch[h];
		ch[h] = temp;
		
	}

}
