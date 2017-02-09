package com.MT.forkJoin;

import java.util.concurrent.ForkJoinPool;

public class Test {
public static void main(String[] args) {
	Problem test = new Problem();
    // check the number of available processors
	long start =  System.currentTimeMillis();
    int nThreads = Runtime.getRuntime().availableProcessors();
    System.out.println(nThreads);
    Solver mfj = new Solver(test.getList());
    ForkJoinPool pool = new ForkJoinPool(nThreads);
   long result =  pool.invoke(mfj);
   long end = System.currentTimeMillis();
    //long result = mfj.get();
   System.out.println("Time taken through Fork Join is " + (end- start) + " ms");
    System.out.println("Done. Result: " +result );
    
    long start1 =  System.currentTimeMillis();
    long sum = 0;
    // check if the result was ok
    for (int i = 0; i < test.getList().length; i++) {
            sum += test.getList()[i];
    }
    long end1 = System.currentTimeMillis();
    System.out.println("Time taken through loop is " + (end-start)+ " ms");
    System.out.println("Done. Result: " + sum);
}
}
