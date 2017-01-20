package com.HR.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArr_ArrList {
   
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int nSeq=sc.nextInt();
		int nQue = sc.nextInt();
		int arr[][]=new int[nQue][nQue];
		for(int i=0;i<nQue;i++){
			for(int j=0;j<3;j++){
				arr[i][j]=sc.nextInt();
			}
		}
		
		getOutput(arr,nSeq,nQue);
		
		
		
	}

	private static int[] getOutput(int[][] arr, int nSeq, int nQue) {
		int retArr1[]=new int[nQue];
		int retArr2[]=new int[nQue];
		
		int lastAns=0;
		List<Integer> seq=new ArrayList<Integer>(nSeq);
		for(int i=0;i<nQue;i++){
			for(int j=0;j<3;j++){
				if(arr[i][0]==1){
					if((arr[i][j+1]^lastAns)%nSeq==0) {
						seq.add(0,arr[i][j+2]);
					}else{
						seq.add(1,arr[i][j+2]);
					}
				}
				if(arr[i][0]==2){
					if((arr[i][j+1]^lastAns)%nSeq==0) {
					System.out.println(seq.get((arr[i][j+1]^lastAns)%nSeq));
					}
					
				}
			}
			
		}
		
		
		
		return retArr1;
	
		
	}
	
	
	
}
