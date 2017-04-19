package com.MS;

import java.util.Scanner;

public class Str_Rep {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String p = sc.nextLine();
		String r = sc.nextLine();

		System.out.println(doReplace(s, p, r));

	}

	private static String doReplace(String s, String p, String r) {

		int matchingIndex = getMatchingIndex(s, p);
		char[] newChars = new char[s.length() - p.length() + r.length()];
		if (matchingIndex == -1)
			return s;
		else {
			for (int i = 0; i < s.length(); i++) {
				if (i < matchingIndex) {
					newChars[i] = s.charAt(i);
				} else if (i == matchingIndex) {
					for (int j = 0; j < r.length(); j++) {
						newChars[i+j] = r.charAt(j);
						
					}
					i = i + p.length() - 1;

				} else {

					newChars[i + r.length() - p.length()] = s.charAt(i);

				}

			}

		}

		return new String(newChars);
	}

	private static int getMatchingIndex(String s, String p) {
		int match = -1;
		outer: for (int i = 0; i < s.length() - p.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (s.charAt(i+j) != p.charAt(j))
					continue outer;
			}
			match = i;
			break;
		}

		return match;
	}
}
