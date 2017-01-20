package com.Inheritance;

public class PassBYValEx {
public static void main(String[] args) {
	StringBuffer s= new StringBuffer("a");
	String s1 ="String";
	int i=1;
	chkPassByVal(s,i,s1);
	System.out.println(s.toString());
	System.out.println(i);
	System.out.println(s1);
	
}

private static void chkPassByVal(StringBuffer s1, int i,String s2) {
	 s2="b";
     s1=new StringBuffer("b");
     ++i;
	
}
	
}
