package com.DP.Behavior;

public class MallardDuck extends Duck {
	
	public MallardDuck(){
		qckBh = new Quack();
		flyBh=new FlyNoWay() ;
		
	}
	

	@Override
	public void display() {
	
		System.out.println("I am real Mallard duck!!");

	}

}
