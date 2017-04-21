package com.HR.StringsAlgo;

import java.util.Arrays;

public class StringRev {
	public static void main(String[] args) {
		String str = "gowri";
		char[] s = str.toCharArray();
/**Swapping Elements without using temp variable 
 * 
 * 
 * 
 */
		for (int i = 0, j = s.length - 1; j > i; i++, j--) {
			
			
			s[i] = (char) (s[i] ^ s[j]);
			s[j] = (char) (s[i] ^ s[j]);
			s[i] = (char) (s[i] ^ s[j]);
			
		

		}
		str = Arrays.toString(s);
		System.out.println(str);
		
        str= reverseUsingRecursion(str);		
        System.out.println(str);

	}

	private static String reverseUsingRecursion(String str) {
		if(str.length()==1) return str;
			
		return reverseUsingRecursion(str.substring(1))+str.charAt(0);
	}
}
