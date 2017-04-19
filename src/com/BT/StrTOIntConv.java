package com.BT;

import java.util.Scanner;

public class StrTOIntConv {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	String str=sc.nextLine();
	int num = convStrToInt(str);
	System.out.println(num);
	
}

private static int convStrToInt(String str) {
	int numb=0;int fact=1;
	for(int i=str.length()-1;i>=0;i--){
		numb += (str.charAt(i)-'0') *fact;
		fact *= 10;
	}
	
	
	return numb;
}
}
