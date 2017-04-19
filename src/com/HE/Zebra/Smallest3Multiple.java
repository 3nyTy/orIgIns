package com.HE.Zebra;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.HashSet;

import java.util.Set;

import java.util.StringTokenizer;

public class Smallest3Multiple {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<Character> nums = new HashSet<Character>();
		String numbers = br.readLine();
		StringTokenizer str = new StringTokenizer(numbers);
		while (str.hasMoreTokens()) {
			nums.add(str.nextToken().charAt(0));
		}
		int k = Integer.parseInt(br.readLine());
		System.out.println(getMinThreeMultiple(nums, k));
	}

	private static int getMinThreeMultiple(Set<Character> nums, int k) {
		int start = (int) Math.pow(10, k - 1) + 2;
		int end = (int) Math.pow(10, k) - 1;
		for (int i = start; i <= end; i = i + 3) {
			if (isRequiredNum(String.valueOf(i), nums)) {
				return i;
			}
		}
		return -1;
	}

	private static boolean isRequiredNum(String number, Set<Character> nums) {
		for (char ch : number.toCharArray()) {
			if (!nums.contains(ch)) {
				return false;
			}
		}
		return true;
	}
}
