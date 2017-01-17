package com.iB;

public class InsetLL_Tail {

	static void Insert(Node head,int data){
		Node temp=new Node();
		temp.data=data;
		temp.next=head;
		head=temp;
		
	//	return head;
		
		
		
	}
	public static void main(String[] args) {
		Node n=new Node();
	//	n.data=3;
		Insert(n,3);
		
	}
	
}

class Node{
	Node next;
	int data;
	
	
}