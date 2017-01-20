package com.HR.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class two_DimenArr {
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	int arr[][]=new int[6][6];
	for(int i=0;i<6;i++){
		for(int j=0;j<6;j++){
			arr[i][j]=sc.nextInt();
		}
		
		
	}
	/*for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			System.out.printf(arr[i][j+1] + " ");
		}
		System.out.println(" ");
	}*/
	System.out.println(calculatehourglssSum(arr));
	
}

private static int calculatehourglssSum(int[][] arr) {
	int x=0;
	int count[] = new int[4*4];
  for(int i=0;i<4;i++){
	  for(int j=0;j<4;j++){
		  count[x] = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
		  x++;
	  }
  }
	Arrays.sort(count);
	
	
	return count[count.length-1];
}


}
