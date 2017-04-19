package com.JP;

public class Node {
	private Student stuObj;
	private Node next;
	private Node prev;
	public Node(Student stuObj){
		this.stuObj = stuObj;
	}
	public Student getStuObj() {
		return stuObj;
	}
	public void setStuObj(Student stuObj) {
		this.stuObj = stuObj;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	public String toString(){
		return stuObj.getName()+" "+stuObj.getMarks()+" "+stuObj.getPercentage()+" "+stuObj.getRank();
		
	}

}
