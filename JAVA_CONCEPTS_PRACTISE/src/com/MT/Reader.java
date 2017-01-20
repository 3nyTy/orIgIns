package com.MT;

public class Reader extends Thread {
	Calculator c;
	
	Reader(Calculator calc){
		c=calc;
	}
	public void run(){
		synchronized(c){
		System.out.println("Waiting for calculation..");
		try {
			c.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Total is: "+c.total);
		
	}
	

}
	
	public static void main(String[] args) {
		Calculator c= new Calculator();
		
		new Reader(c).start();
		new Reader(c).start();
		new Reader(c).start();
		
		c.start();
		
		
		
	}
	
	
}
class Calculator extends Thread{
	int total;
	
	public void run(){
		synchronized (this) {
			
		
		for(int i=0;i<100;i++){
			total+=i;
		}
		notifyAll();
		}
		
		
		
	}
	
	
	
}