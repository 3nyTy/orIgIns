package com.DS.Strng;

import java.util.Scanner;

public class StrngRepl {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String repStr = sc.nextLine();
		String anothrStr = sc.nextLine();
		char[] s =str.toCharArray();
		char[] p=repStr.toCharArray();
		char[] r = anothrStr.toCharArray();
		int matchingindex=getMatchingIndex(s,p);
		if(matchingindex==-1) {
			System.out.println( str) ;
		}
		else{
		System.out.println(replaceString(s,p,r,matchingindex));
		}
		
		
		
	}

	private static int getMatchingIndex(char[] s, char[] p) {
		int matchingindex=-1;
	outer :	for(int i=0;i<s.length-p.length;i++){
			for(int j=0;j<p.length;j++){
				if(s[i+j]!=p[j]) continue outer;
				
			}
			matchingindex=i;
			break;
		}
		
		
		
		return matchingindex;
	}

	private static String replaceString(char[] s, char[] p,char[] r, int matchingindex) {
	char[] newchar = new char[s.length - p.length + r.length];
	for(int i=0;i<s.length;i++){
		if(i<matchingindex){
			newchar[i] = s[i];
		}else if(i == matchingindex){
			for(int j=0;j<r.length;j++){
				newchar[i+j] = r[j];
			}
			i=i+p.length-1;
			
		}
		else{
			newchar[i-p.length+r.length]=s[i];
			
			
		}
	}
		return new String(newchar);
	}
	
}
