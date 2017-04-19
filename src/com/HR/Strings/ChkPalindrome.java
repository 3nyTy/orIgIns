package com.HR.Strings;

import java.util.Scanner;

public class ChkPalindrome {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(isPalindrome(str));
		
	}

	private static boolean isPalindrome(String s) {
		 int n = s.length();
		  for (int i = 0; i < (n/2); ++i) {
		     if (s.charAt(i) != s.charAt(n - i - 1)) {
		         return false;
		     }
		  }

		  return true;
		
		
	}
}
