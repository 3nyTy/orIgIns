package com.HR.Searching;


public class SearchIncrDecrArr {
	public static void main(String[] args) {
		int[] arr = new int[] { 25, 26, 27, 48, 50, 60, 70, 46, 22, 18, 14 };
		int elem = 70;
		int position = 0;
		int index = getIndexOfDec(arr);Boolean isAscending=false;
		if (elem < arr[0]) {
			
			position = binarySearch(arr, index , arr.length - 1, elem,isAscending);
		} else {
			isAscending = true;
			position = binarySearch(arr, 0, index-1, elem,isAscending);
		} 
		System.out.println(position);
		int searchIndex=binarySearchRecur(arr,0,arr.length-1,elem);
		System.out.println(searchIndex);
	}

	private static int binarySearchRecur(int[] arr, int low, int high, int elem) {
		if(low>high) return -1;
		int mid = (low+high)/2;
		if(arr[mid]== elem) return mid;
		if(arr[low]<=arr[mid]){
			if(elem >= arr[low] && elem <=arr[mid]){
				return binarySearchRecur(arr,low,mid-1,elem);
			}
			return binarySearchRecur(arr, mid+1, high, elem);
		}
		
		 if(elem<=arr[mid] && elem >= arr[high]){
			return binarySearchRecur(arr, mid+1, high, elem);
		}
		return binarySearchRecur(arr, low, mid-1, elem);
	}

	private static int binarySearch(int[] arr, int low, int high, int elem,boolean isAscending) {
		
		while(low<=high){
			int middle = (low+high)/2;
			if(elem == arr[middle]) return middle;
			else{
				if(isAscending){
					if(elem>arr[middle]){
						low=middle+1;
					}else{
						high=middle-1;
					}
					
				}else{
					
					if(elem > arr[middle]){
						high=middle-1;
					}else{
						low=middle+1;
					}
					
					
					
				}
				
				
				
			}
			
			
		}
		
		
		return -1;
		 
	}

	private static int getIndexOfDec(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]){
				return i;
		}
		}

		return 0;
	}
}
