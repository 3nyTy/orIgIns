package com.HR.Searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchIceCreamParlor {
	  public static int binarySearch(int first, int last, IceCream[] arr, int search) {
		 while(first <= last){
			 int middle = ( first+last)/2;
			 if(arr[middle].equals(search)) return arr[middle].index;
			 if(arr[middle].compareInt(search)<0){
				 first = middle+1;
			 }else {
				 last = middle-1;
			 }
			 
			 
		 }
		  return -1;
	        
	        
	    }

	    public static void main(String[] args) {
	        
	        int t;
	        int n, m;
	 
	        Scanner in = new Scanner(System.in);
	        t = in.nextInt();
	       for(int test = 0; test < t; test++) {       
	            
	            m = in.nextInt();
	            n = in.nextInt(); 
	            IceCream[] arr = new IceCream[n];
	    
	            for (int i = 0; i < n; i++)
	                arr[i] = new IceCream(in.nextInt(), i + 1);
	            
	            Arrays.sort(arr);
	            int firstIndex = 100000, secondIndex = 100000;
	            for(int i = 0; i < n - 1 ; i++) {
	            	System.out.println("The value of m is : " +m);
	            	int search = m - arr[i].flavor;
	            	System.out.println("Value to be searched is : "+search);
	                if(search >= arr[i].flavor) {
	                    int index = binarySearch( i + 1, n - 1, arr, search);
	                    if( index != -1 ) {
	                        System.out.println( Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
	                        break;

	                    }
	                }
	            } 
	            
	        }
	        
	    }
}
class IceCream implements Comparable<IceCream>{
    int flavor;
    int index;

    public IceCream(int flavor, int index) {
      this.flavor = flavor;
      this.index=index;
    }
   
    @Override
    public int compareTo(IceCream o) {
    	return (this.flavor - o.flavor);
       
    }
    public int compareInt(int o) {
        return (int)(this.flavor-o);
       
    }
    @Override
    public boolean equals(Object o){
    	
    	
        return (this.flavor==(Integer)o ? true:false);
    }
        
}
