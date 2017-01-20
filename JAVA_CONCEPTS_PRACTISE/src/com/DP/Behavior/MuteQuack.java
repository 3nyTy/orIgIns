package com.DP.Behavior;

public class MuteQuack implements QuackBehaviour {

	@Override
	public void quack() {
		System.out.println("I dont make any sound");
	}

}
