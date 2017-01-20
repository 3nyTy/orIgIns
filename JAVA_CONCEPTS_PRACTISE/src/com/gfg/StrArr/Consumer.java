package com.gfg.StrArr;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	BlockingQueue queue ;
	public Consumer(BlockingQueue queue){
		this.queue=queue;
	}
	@Override
	public void run() {
		int value;
		while(true){
			try {
				value=(Integer) queue.take();
				System.out.printf("The consumer consumed %s values %n",value);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
