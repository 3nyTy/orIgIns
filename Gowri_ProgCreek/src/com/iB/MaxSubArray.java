package com.iB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MaxSubArray {

	public static void main(String[] args) throws IOException {
		List<Integer> a = new ArrayList<Integer>();
		// Scanner sc=new Scanner(System.in);
		/*
		 * while(sc.hasNext()){ a.add(sc.nextInt()); }
		 */
		/*
		 * for(int i=0;i<a.size();i++){ a.add(sc.nextInt()); }
		 */
		// a.add(-2);a.add(1);a.add(-3);a.add(4);a.add(-1);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		while (line.length() > 0) {
			a.add(Integer.valueOf(line));
			line = br.readLine();
		}

		int maxNum = maxSubArray(a);
		System.out.println(maxNum);
	}

	public static int maxSubArray(final List<Integer> a) {
		// int sum=0;
		Set<Integer> se = new TreeSet<Integer>();
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.size(); j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum = sum + a.get(k);
					// System.out.println("Sum at i " + i +" j and " + j +
					// " and k " + k + " is :" +sum);
					se.add(sum);
					// sum=sum+a.get(j);
				}

			}
		}
		Object[] arr = se.toArray();
		return (Integer) (arr[arr.length - 1]);

	}
}
