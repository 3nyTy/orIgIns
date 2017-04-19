package com.DS.Recur;

public class RecurseEx {
	public static void main(String[] args) {

		new RecurseEx().getabc(6);
	}

	private int getabc(int x) {

		if (x > 30)
			return x;
		System.out.println("Up" + x);
		x = x + getabc(x + 10);
		System.out.println("Down" + x);
		return x;

	}
}
