package com.MT;

public class ThreadLocal_Ex {
public static class MyRunnable implements Runnable{

	private ThreadLocal<Integer> tl_int = new ThreadLocal<Integer>();
	//private Integer tl_int = new Integer(5);
	
	@Override
	public void run() {
		
		tl_int.set((int) (Math.random()*100));
		//tl_int = (int) (Math.random()*100);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(tl_int.get());
		//System.out.println(tl_int);
	}
	
	
}
	
	public static void main(String[] args) throws InterruptedException {
		
		MyRunnable sharedInstance = new  MyRunnable();
		Thread t1=new Thread(sharedInstance);
		Thread t2=new Thread(sharedInstance);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
	}
	
}
