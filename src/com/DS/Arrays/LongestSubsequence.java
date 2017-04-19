package com.DS.Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestSubsequence {
public static void main(String[] args) {
	
	int[] a = new int[]{1,9,3,10,4,20,2};
	Set<Integer> set = new HashSet<Integer>();
	for(int i=0;i<a.length;i++){
		set.add(a[i]);
	}
	int j=0;int ans=0;
	for(int i=0;i<a.length;i++){
		if(!set.contains(a[i]-1)){
			j = a[i];
			while(set.contains(j))
				j++;
			if(ans<j-a[i]){
				ans = j-a[i];
			}
			
		}
		
	}
	
	System.out.println(ans);
}
}
