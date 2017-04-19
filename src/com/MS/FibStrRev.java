/***
 * Rev string at fibonacci indexes.
 * Eg : zero one two three four five six seven
 * Fibonacci indexes - 1 1 2 3 5
 * O/p: zero eno qwt eeht four evif seven...
 * 
 * 
 * **/

package com.MS;

import java.util.Arrays;
import java.util.Scanner;

public class FibStrRev {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str=printRevStr(str);
		System.out.println(str);
		
	} 

	private static String printRevStr(String str) {
		StringBuilder sb = new StringBuilder();
		String[] strArr = str.split(" ");
		int[] fib = new int[strArr.length];
		fib=getFib(fib,strArr.length);
		int i=0;
		
		for(int j=2;j<strArr.length;j++){
			if(j==(j-1)+(j-2)){
			//	System.out.println(fib[j]);
			strArr[j] = new StringBuilder(strArr[j]).reverse().toString();
			}
			
		}
		return Arrays.toString(strArr);
	}	

	private static int[] getFib(int[] fib,int strLength) {
		fib[0]=1;fib[1]=1;
		for(int i=2;i<strLength;i++){
			fib[i]=fib[i-1]+fib[i-2];
		}
		
		return fib;
	}

}
