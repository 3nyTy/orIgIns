/**Remove duplicate elements in LL**/

package com.HR.LL;



public class TestLL {
	Node head;
	public static void main(String[] args) {
		TestLL ll = new TestLL();
		ll.head = new Node(1);
		Node second=new Node(1);
		Node third=new Node(2);
		ll.head.next=second;
		second.next=third;
		Node four=new Node(3);
		third.next=four;
		removeDuplicates(ll.head);
		traverseList(ll.head);
	}
	private static void traverseList(Node head) {
		Node temp=head;
		while(temp!=null){
			System.out.println("===========");
			System.out.println(temp.data);
			temp=temp.next;
		}
		
		
	}
	private static Node removeDuplicates(Node head) {
		
		if(head==null || head.next==null ) return head ;
		Node temp=head;	
		
		while(temp.next!=null ){
			if(temp.data!=temp.next.data){
				temp=temp.next;
			}else{
			
				temp.next=temp.next.next;
			}
			
		}
		
		return head;
		
		
	}
	private static void removeLink(Node temp) {
		Node curr= temp;
		
	}
	
	
	

}

class Node{
	
	int data;
	Node next;
	
	Node(){};
	Node(int data){
		this.data=data;
		this.next=null;
	}
}