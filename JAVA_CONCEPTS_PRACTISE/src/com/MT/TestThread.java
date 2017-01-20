package com.MT;

 class MyThread extends Thread {
MyThread(){
	System.out.println("My thread");
}
public void run(){
	System.out.println("bar");
	
}

public void run(String s){
	System.out.println("barsssssss");
	
}


}

 public class TestThread{
	 
	 public static void main(String[] args) {
		
		 Thread t =new MyThread(){
		
			public void run() {
			System.out.println("Inside mythread");
				
			}
		
	};
	t.start();
	
	 }
 }