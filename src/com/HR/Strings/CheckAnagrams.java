package com.HR.Strings;

import java.util.Scanner;

public class CheckAnagrams {
public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	String str1 = sc.nextLine();
	String str2 = sc.nextLine();
	int[] arr = new int[26];
	str1 = str1.toLowerCase();
	str2 = str2.toLowerCase();
	System.out.println(checkanagrams(str1,str2,arr));
	
	
}

private static boolean checkanagrams(String str1, String str2,int[] arr) {
	for(int i=0;i<str1.length();i++){
		int index = str1.charAt(i) - 'a';
		arr[index]=1;
	}
	
	for(int i=0;i<str2.length();i++){
		int index=str2.charAt(i)-'a';
		if(arr[index]!=1) return false;
		
	}	
	return true;
}
}
