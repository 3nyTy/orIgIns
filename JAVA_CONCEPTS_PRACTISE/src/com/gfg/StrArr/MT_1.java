package com.gfg.StrArr;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MT_1 {

	public static void main(String[] args) {
		final Counter mycount=new Counter(new ReentrantLock());
		Runnable r= new Runnable(){

			@Override
			public void run() {
			System.out.printf("Count at thread %s is %d %n",Thread.currentThread().getName(),mycount.getCount());
				
			}
			
		};
		Thread T1=new Thread(r,"T1");
		Thread T2=new Thread(r,"T2");
		
		T1.start();
		T2.start();
		
	}
	
}


class Counter{
	private Lock lock;
	private int value;
	public Counter(Lock lock){
		this.lock=lock;
	}
	
	public final int getCount(){
		//lock.lock();
		synchronized(this){
		value++;
		}
		//lock.unlock();
			return value;
		
	}
	
}