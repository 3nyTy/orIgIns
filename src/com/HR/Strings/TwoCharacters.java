package com.HR.Strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoCharacters {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		String s = in.next();
		Set<Character> charSet = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			charSet.add(s.charAt(i));
		}
		Character[] chr = charSet.toArray(new Character[charSet.size()]);
		System.out.println(getFinalLength(s, chr));
		in.close();
	}

	private static int getFinalLength(String s, Character[] chr) {
		int mLength = 0;
		String str = "";
		for (int i = 0; i < chr.length; i++) {
			for (int j = i + 1; j < chr.length; j++) {
				str = makeString(s, chr[i], chr[j]);
				if (chkAlternateCharacter(str)) {
					if (str.length() > mLength) {
						mLength = str.length();
					}

				}

			}
		}
		return mLength;
	}

	private static String makeString(String s, char a, char b) {

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != a && s.charAt(i) != b) {
				s = s.replaceAll(Character.toString(s.charAt(i)), "");
				i = 0;

			}

		}
		return s;
	}

	private static Boolean chkAlternateCharacter(String s) {
		for (int i = 0; i < s.length() - 2; i++) {
			if (s.charAt(i) != s.charAt(i + 2))
				return false;
		}

		return true;
	}
}
