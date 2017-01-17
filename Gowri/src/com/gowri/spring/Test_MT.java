package com.gowri.spring;

public class Test_MT {
	
	public static void main(String[] args) {
		
		Thread t=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Inside run");
				
			}});
		t.start();
		System.out.println("Inside main");
		
				
		
		
	}

}
