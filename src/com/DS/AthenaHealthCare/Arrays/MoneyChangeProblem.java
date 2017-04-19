package com.DS.AthenaHealthCare.Arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MoneyChangeProblem {
	public static void main(String[] args) throws IOException {
		int n = 100000;
		long k = 44850;

		int res = maxMoney(n, k);
		int sum = maxMoneyDP(n,k);
		System.out.println(res);

	}

	private static int maxMoneyDP(int n, long k) {
      //  int[][] ar = new int[(int)k+1][]
		
		
		return 0;
	}

	private static int maxMoney(int n, long k) {
		long sum = n * (n + 1) / 2;
		if (isConsecMultipleNum(2 * k)) {
			return (int) ((sum - 1) % (Math.pow(10, 9) + 7));
		} else {
			return (int) ((sum) % (Math.pow(10, 9) + 7));
		}
	}

	private static boolean isConsecMultipleNum(long num) {
		double sqrt = Math.sqrt(num);
		int integerSqrt = (int) sqrt;
		if (sqrt == integerSqrt) {
			return false;
		}

		int first = (int) Math.floor(sqrt);
		int second = (int) Math.ceil(sqrt);

		return (first * second) == num;
	}
}
