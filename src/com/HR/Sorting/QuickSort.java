package com.HR.Sorting;

public class QuickSort {
public static void main(String[] args) {
	int[] arr = new int[]{10,30,5,70,20,15,90,14,25,12,13,18,6,2,1};
	int low=0;int high=arr.length-1;
	sortArrayUsingQuickSort(arr,low,high);
	System.out.println("After sorting : ");
	for(int i=0;i<arr.length;i++){
		System.out.println(arr[i]+" ");
	}
}

private static void sortArrayUsingQuickSort(int[] arr, int low, int high) {
	
	int idPart = partition(arr,low,high);
	System.out.println("partition id is : "+ idPart +" , "+ arr[idPart]);
	System.out.println("low: " +low+" High : "+high);
	if(low<idPart-1){
		sortArrayUsingQuickSort(arr, low, idPart-1);
	}
	if(high>idPart){
		sortArrayUsingQuickSort(arr, idPart, high);
	}
	
}

private static int partition(int[] arr, int left, int right) {
	System.out.println("-----Inside partition-------");
	int pivot = arr[left];
	while(left<=right){
		System.out.println("Left : "+left +" , " + arr[left] +" ;Right : " +right + " , "+arr[right]+ " ;pivot : "+pivot);
		while(arr[left]<pivot){
			left++;
		}
		while(arr[right]>pivot){
			right--;
		}
	
	
	if(left<=right){
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
		
		left++;
		right--;
	}
	}
	System.out.println("-----Exit From partition-------");
	return left;
}
}
