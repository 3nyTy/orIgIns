package com.HR.Sorting;

import java.util.Scanner;

public class SortUsingInsertion {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       
       insertionSortPart2(ar);    
       
      
       printArray(ar);
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
    
    
    public static void insertionSortPart2(int[] a)
    {       long startTime = System.currentTimeMillis();
    System.out.println(startTime);
           for(int i=1;i<a.length;i++){
        	   for(int j=i;j>0;j--){
        	   if(a[j]<a[j-1]){
        		   int temp = a[j];
        		   a[j] = a[j-1];
        		   a[j-1] = temp;
        		  
        	   }
        	  
        	   
           }
        	   
        	 //  printArray(a);
    }  
           long endTime = System.currentTimeMillis(); 
           System.out.println(endTime);
    	   long totalTime = endTime-startTime;
           System.out.println(totalTime);
}
}
