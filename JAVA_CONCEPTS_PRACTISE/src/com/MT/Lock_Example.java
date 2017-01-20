package com.MT;

public class Lock_Example {

 boolean isLocked=false;
Thread lockedBy=null;
int lockedcount=0;
 
 public synchronized void lock() throws InterruptedException{
	 Thread callingThread = Thread.currentThread();
	 System.out.println(isLocked);
	 System.out.println(callingThread.getName());
	 if(lockedBy!=null)
	 System.out.println(lockedBy.getName());
	 
	 while(isLocked && lockedBy!=callingThread ){
		 System.out.println("I will wait now.....");
		 wait();
		 System.out.println("I am gng to wait now.....");
	 }
	 isLocked = true;
	 lockedcount++;
	 System.out.println(lockedcount);
	 lockedBy = callingThread;
	 System.out.println(Thread.currentThread().getName());
 }
	
 public synchronized void unlock(){
	 
	 isLocked = false;
	 notify();
	 System.out.println("I am awakening u....");
 }
 public static void main(String[] args) throws InterruptedException {
	
	 Renetrance rt= new Renetrance();
	 Thread t = new Thread(rt);
	 t.setName("This is first thread");
	// Thread t1 = new Thread(rt);
	// t1.setName("This is second thread");
	t.start();
	/// t1.start();
	t.join();
	// t1.join();
	 
}
 
	
}

class Renetrance implements Runnable{
	Lock_Example lck = new Lock_Example();
	
	public synchronized void  outer() throws InterruptedException{
		lck.lock();
		System.out.println("I m inside outer block");
		inner();
		lck.unlock();
	}
	
	public synchronized void  inner() throws InterruptedException{
		lck.lock();
		System.out.println("I am inside inner block");
		lck.unlock();
	}

	@Override
	public void run() {
		
		try {
			outer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}