

package com.HR.WarmUp;

import java.util.Scanner;
public class TripletLong {
public static void main(String[] args) {
	
	 Scanner in = new Scanner(System.in);
	 /**
	  * Compare Triplets and assign points to them.
	  * 
	  * */
    /* int a0 = in.nextInt();
     int a1 = in.nextInt();
     int a2 = in.nextInt();
     int b0 = in.nextInt();
     int b1 = in.nextInt();
     int b2 = in.nextInt();
    int pA=(a0>b0 ? 1:0) + (a1>b1 ? 1:0) + (a2>b2 ? 1:0);
    int pB = (a0<b0 ? 1:0) + (a1<b1 ? 1:0) + (a2<b2 ? 1:0);
	System.out.print(pA + " " + pB);
	
	 Scanner in = new Scanner(System.in);*/
	 /**For Long sum**/
     int n = in.nextInt();
     int arr[] = new int[n];
     for(int arr_i=0; arr_i < n; arr_i++){
         arr[arr_i] = in.nextInt();
     }
     long sum=0;
     for(int i:arr){
    	 sum=sum+i;
     }
	System.out.println(sum);
}
}
