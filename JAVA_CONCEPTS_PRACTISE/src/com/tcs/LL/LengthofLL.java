package com.tcs.LL;

import java.util.Scanner;

public class LengthofLL {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	while(t-- >0){
		int x = sc.nextInt();
		Node head= new Node();
		int l=x;
		while(l-- >0){
			int y=sc.nextInt();
			head=head.Insert(head, y);
			
		}
		head.Print(head.next);
	}
	
	
	
}
}
