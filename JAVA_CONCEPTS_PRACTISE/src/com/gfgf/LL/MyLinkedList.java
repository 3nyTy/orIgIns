package com.gfgf.LL;

public class MyLinkedList {

	Node head;
	
	 static class Node{
		Node next;
		int data;
		Node(){};
		Node(int data){
			this.data=data;
			this.next=null;
		}
		
	}
	public static void main(String[] args) {
		
		MyLinkedList link = new MyLinkedList();
		link.head = new Node(1);
		Node second=new Node(2);
		Node third=new Node(3);
		link.head.next=second;
		second.next=third;
	//third.next=second;
		System.out.println("Original List :");
		link.traverseList(link.head);
		boolean isLoop=detectCycle(link.head);
		System.out.println(isLoop);
		GetElementatNthfromTail(link.head,2);
		
		/*Node begin = new Node(0);
		link.insertElemAtBegin(link,begin);
		System.out.println("After insert at beginning :");
		link.traverseList(link.head);
		Node end = new Node(5);
		link.insertElemAtEnd(link,end);
		System.out.println("After insert at end :");
		link.traverseList(link.head);
		Node middle = new Node(4);
		Node previous=link.head.next.next.next;
		link.insertElemAtMiddle(link,middle,previous);
		System.out.println("After insert at middle :");
		link.traverseList(link.head);
		link.deletElem(0);
		System.out.println("After deleting element :");
		link.traverseList(link.head);
		System.out.println("After inserting at nth positon");
		Node n=link.inserttNthNode(link.head,4,2);
		link.traverseList(link.head);
		System.out.println("After deleting at nthNode : ");
		link.DeleteNthNode(link.head, 5);
		link.traverseList(link.head);
		System.out.println("Print Elements in reverse :");
		link.printReverse(link.head);
		System.out.println("Print Elements back through iterartion : ");
		link.printReverseThruIter(link.head);*/
	}
	private static int GetElementatNthfromTail(Node head, int n) {
		int length = getLength(head);
		int pstnfrmStart = length - n;
		 //int start=0;
		    for(int i=1;i<pstnfrmStart;i++){
		        if(head.next!=null){
		        head=head.next;
		        //System.out.println(head.data);
		        }
		       
		    }
		   return head.data;
		
	}
	
	private static int getLength(Node head){
	    int l=0;
	    Node temp=head;
	    while(temp!=null){
	        l++;
	        temp=temp.next;
	    }
	    return l;
	}
	private static  boolean detectCycle(Node head) {
		
		/*if(head == null) return false;
	    Node slw_ptr=head;Node fast_ptr=head.next;
	    while(slw_ptr!=null && fast_ptr.next!=null){
	        
		    if(slw_ptr==fast_ptr) return true;
		    
	    slw_ptr = slw_ptr.next;
	     
	    fast_ptr = fast_ptr.next.next;
	    }
	   
	    return false;
	    */
	    Node tortise=head;
	    Node hare=head;
	    do{
	    	if(hare==null||hare.next==null) return false;
	    	hare=hare.next.next;
	    	tortise=tortise.next;
	    	  	
	    		    	
	    }while(hare!=tortise);
				
		
		   return true;
	}
	private void printReverseThruIter(Node head) {
	
		Node currNode=head;Node prev=null;Node next=null;
		while(currNode!=null){
			next=currNode.next;
			currNode.next=prev;
			prev=currNode;
			currNode=next;
					
		}
		head=prev;
	
		traverseList(head);
		
	}
	private void printReverse(Node head) {
	if(head!=null){
		printReverse(head.next);
		System.out.println(head.data);
		
		
	}
		
		
		
		
	}
	private Node inserttNthNode(Node head, int data, int position) {
		
		if(head==null){
		      head.data=data;
		        return head;
		  }
		    int count=0;
		      Node startNode=new Node();
		      startNode=head;
		    Node insertedNode=new Node();
		    insertedNode.data=data;
		     if(position==0 && head!=null)  {
		    insertedNode.next=head;
		    head=insertedNode;
		     }
		    while(count<position-1 && startNode.next!=null){
		       
		        startNode=startNode.next;
		         count++;
		    }   
		    
		    Node atPos=startNode.next;
		    startNode.next = insertedNode;
		    startNode=startNode.next;
		    startNode.next=atPos;
		    		    
		    return head;
	}
	
	
	private Node DeleteNthNode(Node head, int position) {
		
		
		    if(position==0 && head.next==null){
		        head=null;
		        return head;
		    }
		    if(position==0 && head.next!=null){
		        head=head.next;
		        return head;
		        
		    }
		    
		    int count=0;
		    Node startNode=head;
		   while(count<position-1 && startNode.next!=null ){
		       startNode=startNode.next;
		       count++;
		       
		   }
		    Node deletedNode=startNode.next;
		    startNode.next=deletedNode.next;
		    return head;
		
		
		
		
		
		
	}
	
	
	
	private  void deletElem(int key) {
		
		Node temp=head;
		Node prev=null;
		if(temp!=null && temp.data==key){
			head=temp.next;
			return;
		}
		
		while(temp!=null && temp.data!=key){
			prev=temp;
			temp=temp.next;
		}
		prev.next=temp.next;
	}
	private  void insertElemAtMiddle(MyLinkedList link, Node middle, Node previous) {
		if(previous==null){
			System.out.println("Previous cannot be null");
	      }
		
		Node temp=previous.next;
		previous.next=middle;
		middle.next=temp;
		
		
		
	}
	private  void insertElemAtEnd(MyLinkedList link, Node end) {
		//Node start = link.head;
		if(link.head==null){
			link.head=end;
		}
		end.next=null;
		Node last=link.head;
		while(last.next!=null){
			last=last.next;
		}
		last.next = end;
		
		
		/*while(start!=null){
						
			if(start.next==null){
				start.next = end;
				end.next =null;
			}
			start = start.next;
			
		}*/
		
		
		
	}
	private  void insertElemAtBegin(MyLinkedList link, Node begin) {
		Node Origstart=link.head;
		link.head = begin;
		begin.next = Origstart;
					
		
	}
	
	private  void traverseList(Node head) {
		Node start =head;
		
			while(start!=null){
				System.out.println(start.data + " ");
				start=start.next;
				
			
		}
		
	}
	
}
