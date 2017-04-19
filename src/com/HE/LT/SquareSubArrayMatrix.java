/*Grid Problem
You are given a square grid of size 
N
∗
N
N∗N. Each cell of the grid contains either 
0
0 or 
1
1. A square(consisting of grid cells) is said to be valid if all of its entries are either 
0
0 or 
1
1. You have to output the total number of valid squares in the grid.

Input:

In the first line 
T
T will be given which contains the number of test cases. For each of the test case, first line will contain 
N
N which is the size of the given square grid i.e. 
N
∗
N
N∗N. In the next 
N
N lines 
N
N integers will be given in each line which corresponds to the entries of the grid.

Output:

For each of the test case, output the total number of valid squares in a separate line.

Constraints:

1
≤
T
≤
10
1≤T≤10
1
≤
N
≤
200
1≤N≤200
0
≤
A
[
i
]
[
j
]
≤
1
0≤A[i][j]≤1
Sample Input
3
2
1 1
0 1
3
1 1 1
1 1 1
1 1 1
3
1 1 1
1 0 1
1 1 1
Sample Output
4
14
9
*/



package com.HE.LT;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SquareSubArrayMatrix {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr = null;
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			arr = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			System.out.println(getAllSubSquares(arr));
		}
		sc.close();

	}

	private static int getAllSubSquares(int[][] arr) {
		int i;
		int j;
		int iOff;
		int jOff;
		int off_cnt;
		int sub_mtr_size;
		int sumEachpt = 0;
		int eachArrySum = 0;
		int finalSum = 0;
		for (sub_mtr_size = arr.length; sub_mtr_size > 1; sub_mtr_size--) {
			off_cnt = arr.length - sub_mtr_size + 1;
			for (iOff = 0; iOff < off_cnt; iOff++) {
				for (jOff = 0; jOff < off_cnt; jOff++) {
					sumEachpt = (sub_mtr_size) * (sub_mtr_size);
					for (i = 0; i < sub_mtr_size; i++) {
						for (j = 0; j < sub_mtr_size; j++) {
							eachArrySum += arr[i + iOff][j + jOff];

						}
						// System.out.println(" ");
					}
					if (arr.length == sub_mtr_size) {
						finalSum += sumEachpt;
					} if (eachArrySum == 0 || eachArrySum == sumEachpt) {
						finalSum += 1;
					}
					eachArrySum = 0;
					// System.out.println(" ");

				}
			}

		}

		return finalSum;

	}
}
