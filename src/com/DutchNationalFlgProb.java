/****
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.

Example
Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 * 
 * 
 * 
 */

package com.HR.Sorting;

import java.util.Arrays;

public class DutchNationalFlgProb {
	public static void main(String[] args) {
		int[] ar = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 2} ;
		dutchSortAlgo(ar);
		System.out.println(Arrays.toString(ar));
		
		
	}

	private static void dutchSortAlgo(int[] ar) {
		int low =0;int high = ar.length-1;int mid=0;int temp=0;
		while(mid<=high){
	    System.out.println("Mid : "+mid +" ,value is: " +ar[mid]+" , High : "+high);
			switch(ar[mid]){
			
			case 0 :
				temp = ar[low];
				ar[low] = ar[mid];
				ar[mid]= temp;
				low++;mid++;
				break;
				
			case 1 :
				mid++;
				break;
				
			case 2 :
				temp=ar[mid];
				ar[mid] = ar[high];
				ar[high] = temp;
				high--;
				break;
			
			
			
			
			/*case 0 :
				temp = ar[low];
				ar[low] = ar[mid];
				ar[mid] = temp;
				low++;
				mid++;
				System.out.println("Case 0: "+ Arrays.toString(ar));
				break;
				
			case 1 :
				mid++;
				System.out.println("Case 1: "+ Arrays.toString(ar));
				break;
				
			case 2 :
			    temp = ar[mid];
			    ar[mid] = ar[high];
			    ar[high] = temp;
			    high--;
			    System.out.println("Case 2: "+ Arrays.toString(ar));
			    break;*/
			
			
			
			
			
			
			}
			
			
			
		}
		
		
		
		
	}

}
