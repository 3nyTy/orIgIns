package com.HR.Arrays;

import java.util.Scanner;


public class ReverseArr {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		int reversarr[]=reverseArr(a,0,a.length-1);
		for(int j=0;j<reversarr.length;j++){
		System.out.printf(reversarr[j] + " ");
		}
		
	}

	private static int[] reverseArr(int[] a,int start,int end) {
		
		
		if(start>end){
			return a;
		}
		
		int temp=0;
		temp=a[end];
		a[end]=a[start];
		a[start]=temp;
		start++;
		end--;
		
		
		
		return reverseArr(a,start,end);
		
		
		
	}
	
	
	
	
}
