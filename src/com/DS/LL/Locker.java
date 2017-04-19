package com.DS.LL;

import java.util.Scanner;
import java.util.Stack;

public class Locker {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		for (int i = 1; i <= n; i++) {
			s1.push(i);
		}
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		getLastLockerOpened(s1, s2);
	}

	private static void getLastLockerOpened(Stack<Integer> s1, Stack<Integer> s2) {

		int l1 = s1.size();
		int l2 = s2.size();
		while (l1 != 1 || l2 != 1) {
			if (l2 > l1) {
				copyElements(s1, s2);

			} else {
				copyElements(s2, s1);
			}
			l1 = s1.size();
			l2 = s2.size();
			if (l1 == 1) {
				System.out.println(s1.peek());
				// System.out.println(s2.peek());
				break;
			}
			if (l2 == 1) {
				System.out.println(s2.peek());
				// System.out.println(s1.peek());
				break;
			}
			System.out.println(l1 + " , " + l2);
		}

	}

	private static void copyElements(Stack<Integer> s1, Stack<Integer> s2) {
		while (!s2.isEmpty()) {
			s2.pop();
			if (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}
	}
}
