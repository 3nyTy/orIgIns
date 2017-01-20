package com.gfg.StrArr;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestThread {
public static void main(String[] args) throws InterruptedException {
	BlockingQueue queue = new LinkedBlockingQueue();
	Producer p = new Producer(queue);
	Consumer c= new Consumer(queue);
	Thread t1=new Thread(p);
	Thread t2=new Thread(c);
	t2.start();
	t1.start();
	
	t1.join();
	t2.join();
	
}
}
