package com.HR.Arrays;

import java.util.Scanner;

public class UniqElementsinArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		
		int brr[][]=new int[2][2];
		int count=0;
		int count2=0;
		brr[0][0]=arr[0];
		for(int i=0;i<arr.length;i++){
			
			if(arr[i]==brr[0][0]){
				count++;
			}else{
				brr[1][0]=arr[i];
				count2++;
			}
			
			
			
		}
		brr[0][1]=count;
		brr[1][1]=count2;
		
		System.out.println(brr[0][0] + " " + brr[0][1] + " "+brr[1][0] + " "+brr[1][1]);
		
	}

}
