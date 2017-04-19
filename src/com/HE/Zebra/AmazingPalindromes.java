package com.HE.Zebra;

import java.io.IOException;
import java.util.Scanner;

public class AmazingPalindromes {
	public static void main(String[] args) throws IOException {
/*		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();*/
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(checkAllSubstrings(str));
		sc.close();
	}

	/*private static int getAmazingPalindromes(String str) {
		List<String> strArr = getallSubstrings(str);
		int count = 0;
		String compStr;
		for (String ins : strArr) {
			compStr = getCompressedStr(ins);
			if (isPalindrome(compStr))
				count++;
		}
		return count;
	}*/

	private static String getCompressedStr(String ins) {
		StringBuilder sbr = new StringBuilder();
		if (ins.length() == 1)
			return ins;
		else {
			for (char ch : ins.toCharArray()) {
				if(sbr.length() == 0) {
					sbr.append(ch);
				} else if (sbr.charAt(sbr.length() - 1) != ch) {
					sbr.append(ch);
				} else {
					count++;
				}
			}
		}

		return sbr.toString();
	}

	private static boolean isPalindrome(String s) {
		if(s.length() == 1) {
			return true;
		}
		
		StringBuilder sbr = new StringBuilder(s);
		return s.equals(sbr.reverse().toString());
	}

	/*private static List<String> getallSubstrings(String str) {
		List<String> strArr = new ArrayList<String>();
		String sub;
		for (int i = 0; i < str.length(); i++) {
			for (int j = 1; j <= str.length() - i; j++) {
				sub = str.substring(i, j + i);
				strArr.add(sub);
			}
		}
		return strArr;
	}*/
	
	private static int checkAllSubstrings(String str) {
		int count = 0;
		String sub;
		for (int i = 0; i < str.length(); i++) {
			for (int j = 1; j <= str.length() - i; j++) {
				sub = str.substring(i, j + i);
				sub = getCompressedStr(sub);
				if(isPalindrome(sub)) {
					count++;
				}
			}
		}
		return count;
	}

}
