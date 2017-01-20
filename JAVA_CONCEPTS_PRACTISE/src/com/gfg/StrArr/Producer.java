package com.gfg.StrArr;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	BlockingQueue queue ;
	public Producer(BlockingQueue queue){
		this.queue=queue;
	}

	@Override
	public void run() {
		//int value=0;
		System.out.println("The size of queue is :" +queue.size());
		for(int i=0;i<10;i++){
			try {
				queue.put(i);
			System.out.printf("Producer thread adding %s into queue %n",i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	

}
