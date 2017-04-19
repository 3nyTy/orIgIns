package com.HR.Searching;


public class BinarySearch {

	public static void main(String[] args) {
		
		int elem = 3;
		int[] ar = new int[]{1,2,3,4,5};
		//long startTime  = System.currentTimeMillis();
		Boolean position = binarySearch(ar,elem);
		//long totalTime = System.currentTimeMillis() - startTime;
		//System.out.println(totalTime);
		if(position){
			System.out.println("Element is found");
		}else{
			System.out.println("Element is not found");

		}
		
	}

	private static Boolean binarySearch(int[] ar, int elem) {
        if(ar.length==0) return false;
		int low=0; int high = ar.length-1;
        while(low<=high){
        	int middle = (low+high)/2;
        	if(elem>ar[middle]){
        		low=middle+1;
        	}else if(elem < ar[middle]){
        		high = middle-1;
        	}else{
        		System.out.println(middle);
        	return true	;
        	}
        	
        }
     return false;  
	}
}
