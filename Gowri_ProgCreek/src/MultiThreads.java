package com.WM;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreads {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newFixedThreadPool(10);
	//	boolean finished=exec.awaitTermination(1, TimeUnit.MINUTES);

		Runnable r = new MyThread();
		
		for(int i=0 ;i<5000;i++){
			exec.execute(r);
			
		}

		exec.shutdown();
		exec.awaitTermination(1, TimeUnit.MINUTES);
	}
	
}

class MyThread implements Runnable{

	@Override
	public void run() {
	System.out.println(Thread.currentThread().getName()+",");
		
	}
	
}