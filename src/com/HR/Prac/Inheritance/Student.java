package com.HR.Prac.Inheritance;

public class Student extends Person {
	private int[] testScores;
	Student(String firstName, String lastName, int identification,int[] testScores) {
		super(firstName, lastName, identification);
		this.testScores=testScores;
		// TODO Auto-generated constructor stub
	}
	public String calculate() {
		int sum = 0;int average=0;
		for(int i=0;i<testScores.length;i++){
			sum=sum+testScores[i];
		}
		average=sum/testScores.length;
		if(average>=90 && average<=100) return "O";
		else if (average>=80 && average<90) return "E";
		else if (average>=70 && average<80) return "A";
		else if (average>=55 && average<70) return "P";
		else if (average>=40 && average<55) return "D";
		else   return "T";
		
		
	}

}
