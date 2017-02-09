package com.DS.Stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancingSymbol {
public static void main(String[] args) {
	
	Scanner sc= new Scanner(System.in);
	String str= sc.nextLine();
	boolean flag=checkParenthesisMatch(str);
	System.out.println(flag);
	
	
	
}

private static Boolean checkParenthesisMatch(String str) {

	if(str.length()==0 || str.length()==1) return false;
	
	char[] ch = str.toCharArray();
	Stack<Character> st=new Stack<Character>();
	
	for(char c : ch){
		if(c=='(' || c== '{' || c=='['){
			st.push(c);
		}else if(c==')' || c=='}' || c==']'){
			if(!st.isEmpty()){
				if(c==')' && st.peek()=='(')
				st.pop();
				if(c=='}' && st.peek()=='{')
					st.pop();
				if(c==']' && st.peek()=='[')
					st.pop();
			}
		}
		
	}
	
	
	
	
	return st.isEmpty();
}
}
