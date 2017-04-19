package com.MS;

import java.util.Stack;

public class Queue_Stack {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	public static void main(String[] args) {
		Queue_Stack queue = new Queue_Stack();
		queue.enQueue_DequeCost(1);
		queue.enQueue_DequeCost(2);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		queue.enQueue_DequeCost(3);
		queue.enQueue_DequeCost(4);
		queue.enQueue_DequeCost(5);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}
       /** MAKING DEQUEUE COSTLY**/
	public void enQueue_DequeCost(int a) {
		s1.add(a);
	}

	public int deQueue_DequeCost() {
		if(s2.isEmpty()){
		while(!s1.isEmpty()){
			s2.push(s1.pop());
			
		}
		}
		
		return s2.pop();

	}
        /*******/
	
	
	/***** MAKING ENQUE COSTLY *********/
	public void enQueue_EnqueCost(int a) {
		 
		 if(s2.isEmpty()){
			 while(!s1.isEmpty()){
				 s2.push(s1.pop());
			 }
		 }
		if(s1.isEmpty()){
			s1.push(a);
			while(!s2.isEmpty()){
				s1.push(s2.pop());
			}
		}
		
	}
	
	/*****IMPLEMENT USING 1 STACK WHERE TEMP WILL B RECURSIVE STACK*****/
	public void enQueue_singleStack(int elem){
		if(!s1.isEmpty()){
			int topElem = s1.pop();
			enQueue_singleStack(elem);
			s1.push(topElem);
		}else{
			s1.push(elem);
		}
		
	}
	
	 /******************/

	public int deQueue() {
		return s1.isEmpty() ? s2.pop():s1.pop();

	}
	
	
}
