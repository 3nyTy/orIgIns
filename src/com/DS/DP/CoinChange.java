package com.DS.DP;

import java.util.Scanner;

public class CoinChange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalCount = sc.nextInt();
		int noOfInteger = sc.nextInt();
		int[] coins = new int[noOfInteger];
		for (int i = 0; i < coins.length; i++) {
			coins[i] = sc.nextInt();
		}
		System.out.println(getMaxNumOfWays(coins, totalCount, noOfInteger));

	}

	private static long getMaxNumOfWays(int[] coins, int totalCount,int noOfInteger) {
		long k[][]=new long[noOfInteger+1][totalCount+1];
		for(int i=0;i<= noOfInteger;i++){
			k[i][0]=1;
		}
			for(int i=1;i<=noOfInteger;i++){
				for(int j=1;j<=totalCount;j++){
					 if(coins[i-1]>j)
					 {
						 k[i][j]=k[i-1][j];
						 
					}else{
						k[i][j] = k[i-1][j]+k[i][j-coins[i-1]];
					}
			}
			
			
		}
		

		return k[noOfInteger][totalCount];
	}
}
