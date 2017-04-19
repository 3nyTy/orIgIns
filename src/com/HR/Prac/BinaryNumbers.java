package com.HR.Prac;

import java.util.Scanner;

public class BinaryNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int rem=0;int count=0;int max=0;
		while(n>0){
			rem = n%2;
			if(rem==1) count++;
			else count=0;
			max=Math.max(count, max);
			n=n/2;
			


		}
		

		System.out.println(max);

	}
}
