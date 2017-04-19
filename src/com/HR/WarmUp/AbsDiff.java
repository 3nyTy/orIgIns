package com.HR.WarmUp;

import java.util.Scanner;

public class AbsDiff {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        
        int d1=0;int d2=0;
        
        for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		if(i==j){
        			d1+= a[i][j];
        		}
        		
        		 if(i+j == n-1){
        			d2+=a[i][j];
        			
        		}
        	
        }
        
        
        
    }
        
        System.out.println(Math.abs(d1-d2));
	}
        
}
