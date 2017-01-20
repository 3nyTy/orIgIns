package com.gfg.StrArr;

import java.util.Scanner;



/***Reverse an array without affecting special characters**/


public class RevArr {
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter a String with special characters");
	String str=sc.next();
	System.out.println(revStr(str));
	
}

private static String revStr(String str) {
	//str=
	char[] ch=str.toCharArray();
	//char[] temp;
	str=recrevStr(ch,0,ch.length-1);
	
	return str;
}

private static String recrevStr(char[] ch, int start, int end) {
	
	if(end>start){
		if(!isAlphabet(ch[start])){
			start++;
		}
		else if(!isAlphabet(ch[end])){
			end--;
		}else{
			char temp;
			temp=ch[start];
			ch[start]=ch[end];
			ch[end]=temp;
			start++;
			end--;
				
		}
		recrevStr(ch,start,end);
	}
	
    
    return new String(ch);
}

/*private static void swap(char c, char d) {
	char temp;
	temp=c;
	c=d;
	d=temp;
	
}*/


private static boolean isAlphabet(char c) {
	
	return ((c>='A' && c<='Z')||(c>='a' && c<='z'));
}

}
