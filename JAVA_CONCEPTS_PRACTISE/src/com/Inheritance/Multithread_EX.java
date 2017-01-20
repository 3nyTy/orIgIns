package com.Inheritance;

public class Multithread_EX {

	public static void main(String[] args) {
		
		Thread t=new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("First Thread running");
				
			}
		
		});
		
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	t.run();
		//t.start();
		System.out.println("Second Main thread running");
	
	
	}
	
	
}
