/****
 * For example if input integer array is {2, 6, 3, 9, 11} and given sum is 9, output should be {6,3}.

Read more: http://javarevisited.blogspot.com/2014/08/how-to-find-all-pairs-in-array-of-integers-whose-sum-equal-given-number-java.html#ixzz4dSUmasNw
 * 
 * 
 */
package com.HR.Searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pairs {
	public static void main(String args[]) {
		int[] numbers = { 2, 4, 3, 5, 7, 8, 9 }; 
		int[] numbersWithDuplicates = { 2, 4, 3, 5, 6, -2, 4, 7, 8, 9 };
		/***
		 * Approach using binary search for O(nlogn),but duplicates will be there
		 ***/
		
		prettyPrint(numbers, 7);  
		System.out.println("-----------");
		prettyPrint(numbersWithDuplicates, 7);
		
		/**Second Approach Using Set but space complexity is O(N)**/
		System.out.println("To remove duplicates : ");
		printwithoutDuplicates(numbers, 7);
		System.out.println("------------");
		printwithoutDuplicates(numbersWithDuplicates,7);
		
		
		/*****
		 * Third Approach using two pointers and in-place without duplicates and space
		 * 
		 * *****/
		System.out.println("Two pointers Approach : ");
		printUsingTwoPointers(numbers,7);
		System.out.println("------------");
		printUsingTwoPointers(numbersWithDuplicates,7);
		
		
		}

	private static void printUsingTwoPointers(int[] numbers, int n) {
		int left=0;int right = numbers.length-1;int sum=0;
		Arrays.sort(numbers);
		while(left<=right){
			sum=numbers[left]+numbers[right];
			if(sum==n){
				System.out.println("Left is: "+numbers[left]+" ,Right is : "+numbers[right]);
				left = left+1;
				right=right-1;
				
			}else if (sum > n ){
				right = right-1;
			}else{
				left=left+1;
			}
			
			
		}
		
		
		
	}

	private static void printwithoutDuplicates(int[] numbers, int n) {
        Set<Integer> set = new HashSet<Integer>();
		for(int val : numbers){
			if(!set.contains(n-val)){
				set.add(val);
			}else{
				System.out.println("Value is : "+val+" ,Target is : "+(n-val));
			}
		}
		
	}

	private static void prettyPrint(int[] numbers, int n) {
		Arrays.sort(numbers);
		for(int i=0;i<numbers.length;i++){
			int diff=n-numbers[i];
			int rem = binarySearch(0,numbers.length,numbers,diff);
			if(rem!= -1) System.out.println(numbers[i]+" , " +rem);
		}
	}

	private static int binarySearch(int low, int high, int[] numbers, int searchElem) {
		while(low<=high){
			int middle = (low+high)/2;
			if(searchElem > numbers[middle]){
				low=middle+1;
			}else if(searchElem < numbers[middle]){
				high = middle - 1;
			}else{
				return numbers[middle];
			}
		}
		
		return -1;
	}

}
