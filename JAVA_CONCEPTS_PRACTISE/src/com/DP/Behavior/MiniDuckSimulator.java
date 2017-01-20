package com.DP.Behavior;

public class MiniDuckSimulator {
public static void main(String[] args) {
	
	Duck mallard = new MallardDuck();
	mallard.performFly();
	mallard.performQck();
	mallard.display();
	
	mallard.setFlyBh(new FlyWithRocket());
	mallard.performFly();
	
}
}
