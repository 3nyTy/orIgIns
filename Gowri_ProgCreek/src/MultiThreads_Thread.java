package com.WM;

public class MultiThreads_Thread implements Runnable {
	public static void main(String[] args) throws InterruptedException {
		Thread[] tr = new Thread[10];
		for(int i=0;i<10;i++){
			Thread t = new Thread(new MultiThreads_Thread() );
			tr[i]=t;
			System.out.println("Executing: " +Thread.currentThread().getName()+" , ");
			t.start();	
			
		}
		for(int i=0;i<tr.length;i++){
			System.out.println("Befor Join: " +Thread.currentThread().getName()+" , ");
			tr[i].join();
			System.out.println("After Join: " +Thread.currentThread().getName()+" , ");
		}
		System.out.println(Thread.currentThread().getName());
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" , ");
		
	}

}
