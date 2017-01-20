package com.MT;

public class WaitTest {
public static void main(String[] args) {
	System.out.println("1");
	
	synchronized (args) {
		System.out.println("2");
		
			try {
				args.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("3");
		
	}
	
	
	
}
}
