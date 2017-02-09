package com.MT.forkJoin;

import java.util.Random;

public class Problem {
	private final int[] list = new int[10000];
	
	public Problem(){
		Random generator = new Random (989);
		for(int i= 0 ; i < list.length ; i++){
			 list[i] = generator.nextInt(500);
		
	}

}

	public int[] getList() {
        return list;
}

}