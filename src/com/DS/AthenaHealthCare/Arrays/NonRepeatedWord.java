package com.DS.AthenaHealthCare.Arrays;

import java.util.HashSet;
import java.util.StringTokenizer;

public class NonRepeatedWord {
	public static void main(String[] args) {

		String s = "he had had quite enough.";
		System.out.println(firstRepeatedword(s));

	}

	private static String firstRepeatedword(String s) {

		StringTokenizer str = new StringTokenizer(s, ",:;-. ");
		HashSet<String> set = new HashSet<String>();
		while (str.hasMoreTokens()) {
			String word = str.nextToken();
			if (set.contains(word)) {
				System.out.println(word);
			} else {
				set.add(word);
			}
		}

		return null;

	}
}
