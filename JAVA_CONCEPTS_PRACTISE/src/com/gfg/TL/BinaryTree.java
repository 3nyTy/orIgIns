package com.gfg.TL;

import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
	
	Node root;
	
	BinaryTree(int data){
		root=new Node(data);
	}
	
	BinaryTree(){
		root=null;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		Node root2 = null;
		while(T-->0){
			int data=sc.nextInt();
			root2 = insert(root2,data);
			}
		
		int height = getHeight(root2);
		System.out.println(height);
		
		
		
		/*BinaryTree bt=new BinaryTree();
	    bt.root=new Node(1);
	    bt.root.left=new Node(2);
	    bt.root.right=new Node(3);
	    bt.root.left.left=new Node(4);
	    bt.root.left.right=new Node(5);
	    bt.root.left.right.left = new Node(6);
	    bt.root.left.right.right=new Node(7);
	    
	    System.out.println("InOrderRcursion");
		inOrderTraversal(bt.root);//Left--RootInMiddle--Right 
		System.out.println("----------------------------");
		System.out.println("InOrderIterativ");
		inOrderIteration(bt.root);
		System.out.println("----------------------------");
		System.out.println("InorderWithNOStack");
		inOrderNOStack(bt.root);
		System.out.println("****************************");
		System.out.println("PreOrder");
		preOrderTraversal(bt.root);//Root--left--right
		System.out.println("***************************");
		System.out.println("PreOrder_Iter");
		System.out.println("********");
		preOrder_Iter(bt.root);
		System.out.println("********");
		
		System.out.println("PostOrder");
		postOrderTraversal(bt.root);//Left--Right--Root
*/	}

	private static int getHeight(Node root) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static Node insert(Node root, int data) {
		if(root ==  null) {
			return new Node(data);
		}else{
			Node curr;
			if(data<=root.data){

				curr=insert(root.left,data);
			root.left = curr;
				
			}else{
				
				curr = insert(root.right,data);
				root.right=curr;
				
				
			} 
			
			
			
			
			
		}
		
	
		
		
		
		
		return root;
	}

	private static void preOrder_Iter(Node root) {
		
		Stack<Node> st=new Stack<Node>();
		st.push(root);
		while(st.size()>0){
			Node temp=st.pop();
			System.out.print(temp.data + " ");
						
			if(temp.right!=null){
				st.push(temp.right);
				//System.out.println("Top Element at Stack "+st.peek().data);
			}
						
			if(temp.left!=null){
				st.push(temp.left);
				//System.out.println("Top Element at Stack "+st.peek().data);
			}
			
		}
		
		
		
	}

	private static void inOrderNOStack(Node root) {
		/*Node curr = root;
		Node prev;
		while(curr!=null){
			
				if(curr.left==null){
					System.out.println(curr.data);
						curr=curr.right;
				}else{
						prev=curr.left;
						while(prev.right!=null && prev.right!=curr){
							prev=prev.right;
						
						
					}
				//}
//		}
*/		
			
		
	}

	private static void postOrderIteration(Node root){
		Stack<Node> s = new Stack<Node>();
		Node curr=root;
		while(curr!=null){
			if(curr.left!=null) {
				s.push(curr);
				curr=curr.left;
				if(curr.right!=null){
					
				}
				
				
				
				
				
			}else{
				curr=curr.right;
			}
			
			
		}
		
		
	}
	
	
	
	private static void inOrderIteration(Node root) {
		Stack<Node> s=new Stack<Node>();
		Node curr=root;
		while(curr!=null){
			s.push(curr);
			curr= curr.left;
		}
		while(s.size()>0){
			curr=s.pop();
			System.out.print(curr.data+" ");
			
			if(curr.right!=null){
				curr=curr.right;
				while(curr!=null){
					
					s.push(curr);
					curr=curr.left;
				}
				
				
				
			}
			
			
		}
		
	}

	private static void postOrderTraversal(Node root) {
		if(root==null)return; 
		
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data+" ");
	}

	private static void preOrderTraversal(Node root) {
		if(root==null)return;
		System.out.print(root.data+" ");
		
		preOrderTraversal(root.left);
		
		preOrderTraversal(root.right);
	}

	private static void inOrderTraversal(Node root) {
		
		if(root==null)return;
		inOrderTraversal(root.left);
		System.out.print(root.data+" ");
		inOrderTraversal(root.right);
		
	}
	
	
}
class Node{
	int data;
	Node left;Node right;
	Node(int data){
		this.data=data;
		left=right=null;
		
	}
	
}