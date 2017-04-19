package com.HR.Strings;

import java.util.Scanner;

public class TwoAnagrams {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int[] arr = new int[26];
		str = str.toLowerCase();
		int sum = 1;
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			index = str.charAt(i) - 'a';
			if (index > 0 && index < 26) {
				if (arr[index] == 0) {
					arr[index] = 1;
					sum++;
				}
			}
		}

		if (sum == 26)
			System.out.println("pangram");
		else
			System.out.println("not pangram");

	}

}
