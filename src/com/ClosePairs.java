package com.HR.Searching;

public class ClosePairs {
	// Driver program to test above functions
    public static void main(String args[])
    {
    	ClosePairs ob = new ClosePairs();
        int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        int m = ar1.length;
        int n = ar2.length;
        int x = 38;
        ob.printClosest(ar1, ar2, m, n, x);
    }

	private void printClosest(int[] ar1, int[] ar2, int fLength, int sLength, int x) {
         int diff = Integer.MAX_VALUE;int left=0;int right =0 ;
         int fPointr = 0; int sPointer = sLength-1;
		while(fPointr<fLength && sPointer>=0){
			if(ar1[fPointr]+ar2[sPointer]-x < diff){
				left = fPointr;
				right =sPointer;
				diff= ar1[fPointr]+ar2[sPointer]-x;
				
			}
			if(ar1[fPointr]+ar2[sPointer]>x){
				sPointer--;
			}else{
				fPointr++;
			}
			
			
			
		}
		System.out.println("Closet Pair is : " + ar1[fPointr] +" , "+ar2[sPointer]);
		
	}
}
