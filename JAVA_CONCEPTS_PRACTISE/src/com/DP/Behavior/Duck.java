package com.DP.Behavior;

public abstract class Duck {
	FlyBehaviour flyBh;
	QuackBehaviour qckBh;
	public Duck(){};
	
	public abstract void display();
	
	public void performFly(){
		flyBh.fly();
	}
	public void performQck(){
		qckBh.quack();
	}

	

	public void setFlyBh(FlyBehaviour flyBh) {
		this.flyBh = flyBh;
	}

	

	public void setQckBh(QuackBehaviour qckBh) {
		this.qckBh = qckBh;
	}
	
	
}
