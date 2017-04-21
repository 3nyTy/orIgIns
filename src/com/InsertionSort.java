package com.HR.Sorting;

import java.util.Scanner;

public class InsertionSort {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int s = in.nextInt();
	        int[] ar = new int[s];
	        for(int i=0;i<s;i++){
	            ar[i]=in.nextInt(); 
	        }
	        insertIntoSorted(ar);
	       
	    }
	    
	    
	    private static void printArray(int[] ar) {
	        for(int n: ar){
	            System.out.print(n+" ");
	        }
	        System.out.println("");
	    }
	
	 public static void insertIntoSorted(int[] ar) {
		 int numCompare = ar[ar.length-1];
		 int lengthToComp=ar.length-1;
	      for(int i=lengthToComp;i>=0; i--){
	    	  if(i==0 && numCompare<=ar[0]){
	    		  ar[i] =  numCompare;
	    		  printArray(ar);
	    		  break;
	    		  
	    	  } else if(ar[i-1]>=numCompare){
	    		ar[i]=ar[i-1];
	    		printArray(ar);
	    		
	    	}else if(numCompare>ar[i-1] && numCompare<ar[i+1]){
	    		ar[i]=numCompare;
	    		printArray(ar);
	    		break;
	    	}
	    	 
	    	  
	      }
	 }
}
