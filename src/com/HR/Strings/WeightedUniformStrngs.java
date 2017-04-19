package com.HR.Strings;

import java.awt.AlphaComposite;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WeightedUniformStrngs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = in.nextInt();
		char[] chArr = s.toCharArray();
		Set<Integer> list = new HashSet<Integer>();
		int continuStr = 1;
		int lasNum = 0;

		for (int i = 0; i < chArr.length; i++) {
			int aplhaNum = chArr[i] - 'a' + 1;
			if (aplhaNum == lasNum) {
				continuStr++;
			} else {
				continuStr = 1;
				lasNum = aplhaNum;

			}

			int num = aplhaNum * continuStr;
			list.add(num);

		}

		for (int a0 = 0; a0 < n; a0++) {
			int x = in.nextInt();

			if (list.contains(x)) {
				System.out.println("Yes");
			}

			else {
				System.out.println("No");
			}
		}
	}

}
