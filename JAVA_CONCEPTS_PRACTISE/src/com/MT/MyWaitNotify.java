package com.MT;

public class MyWaitNotify {
 //MonitorObject mntrObj = new MonitorObject();
boolean wasSignalled = false;
	
public void doWait(){
	
	synchronized (this) {
		
		while(!wasSignalled){
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		wasSignalled = false;
	}
	
	
	
}


public void doNotify(){
	
	synchronized (this) {
		wasSignalled = true;
		this.notify();
		
		
	}
	
	
	
}

	
}
