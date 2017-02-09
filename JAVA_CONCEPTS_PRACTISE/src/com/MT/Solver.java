package com.MT.forkJoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class Solver extends RecursiveTask  {
 
	private int[] list;
	public long result;
	
	public Solver(int[] arr){
		this.list = arr;
	}
	
	
	@Override
	protected Long compute() {
		if(list.length==1){
			result= list[0];
			
		}else{
			int midpoint = list.length/2;
			int[] l1 = Arrays.copyOfRange(list,0,midpoint);
			int[] l2= Arrays.copyOfRange(list, midpoint, list.length);
			Solver s1= new Solver (l1);
			Solver s2 = new Solver(l2);
		
           s1.fork();
           s2.fork();

			result =  (Long)s1.join()+(Long)s2.join();	
		}
		return result;
		
	}

}
