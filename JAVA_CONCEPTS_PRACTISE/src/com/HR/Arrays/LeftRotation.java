package com.HR.Arrays;

import java.util.Scanner;

public class LeftRotation {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int d=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		
		arr=performLeftOperation(arr,d);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
	}

	private static int[] performLeftOperation(int[] arr, int d) {
		int temp[] =new int[d];
		for(int i=0;i<d;i++){
			temp[i]=arr[i];
		}
		
		for(int i=0;i<arr.length-d;i++){
			
			arr[i]=arr[i+d];
			
			
		}
		int j=0;
		for(int i=arr.length-d;i<arr.length;i++){
			
			arr[i]=temp[j];
			j++;
		}
		
		
		
		return arr;
		
		
		
		
		
	}
	

}
