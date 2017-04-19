package com.JP;

public class DoublyLinkedList {
    private final int size;
    private int currSize;
    private Node head;
    private Node tail;
    
    public DoublyLinkedList(int size){
    	this.size= size;
    	currSize = 0;
    }

	public int getCurrSize() {
		return currSize;
	}

	public void setCurrSize(int currSize) {
		this.currSize = currSize;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}
    
	public void printList(){
		if(head==null) return;
		else{
			Node tmp=head;
			while(tmp!=null){
				System.out.println(tmp.getStuObj());
				tmp=tmp.getNext();
			}
			
		}
	}
	public Node addStuObjToList(Student stu){
		Node stuNode= new Node(stu);
		if(head==null){
			head=stuNode;
			tail = stuNode;
			currSize=1;
			return stuNode;
		}else if(currSize< size){
			currSize++;
		}else{
			tail = tail.getPrev();
			tail.setNext(null);
			
		}
		stuNode.setNext(head);
		head.setPrev(stuNode);
		head= stuNode;
		return stuNode;
	}
	public void moveNodeToHead(Node stuNode){
		if(stuNode==null || stuNode==head){
			return;
		}
		if(stuNode==tail){
			tail=tail.getPrev();
			tail.setNext(null);
		}
		
		Node prev=stuNode.getPrev();
		Node next= stuNode.getNext();
		if(prev!=null){
		prev.setNext(next);
		}
		if(next!=null){
			next.setPrev(prev);
		}
		
		stuNode.setPrev(null);
		stuNode.setNext(head);
		head.setPrev(stuNode);
		head=stuNode;
	}
}
