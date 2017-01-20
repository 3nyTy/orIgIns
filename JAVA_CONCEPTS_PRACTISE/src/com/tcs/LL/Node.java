package com.tcs.LL;

public class Node {
      int data;
      Node next;
      Node Insert(Node head,int x){
    	  Node temp=new Node();
    	  temp.data=x;
    	  temp.next=null;
    	  if(head==null){
    		  return temp;
    	  }
    	  Node temp1;
    	  for(temp1 = head; temp1.next!=null;temp1=temp1.next);
    	  temp1.next=temp;  
		return head;
    	  
      }

	 void Print(Node head) {
		
	
		   if(head==null || head.next==null)
			    return;
		   else{
			   Node temp=head;
			while(temp!=null){
				System.out.println(temp.data);
				temp=temp.next;
			}
		}
		
		
	}
}
