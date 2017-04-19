package com.HR.TL;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TestTree {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while(t-- > 0){
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		int height = getHeight(root);
		int heiItr = getHeightItr(root);
		System.out.println("Recur : "+height);
		System.out.println("Iter : "+heiItr);


	}
	private static int getHeightItr(Node root) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		if(root!=null) queue.add(root.data);
		if(root.left!=null) {}
		
		
		return 0;
	}
	static int getHeight(Node root) {
		int lHght=0;int rHght=0;
		System.out.println("Root :"+root.data);
		if(root==null) return 0;
		else{
			
			
        
		if(root.left!=null){
			System.out.println("-------LEFT-------");
			System.out.println("LData : " + root.data);
			lHght = 1+getHeight(root.left);
			System.out.println("LHeight : " + lHght);
		}if(root.right!=null){
			System.out.println("-------RIGHT-------");
			System.out.println("RData : " + root.data);
			rHght = 1+getHeight(root.right);
			System.out.println("RHeight : " +rHght);
		}
		}
		return lHght>rHght ? lHght : rHght;
		/*int LHght=getHeight(root.left);
		int rHght=getHeight(root.right);
		if(LHght>rHght) LHght= LHght+1;
		else  rHght = rHght+1;
		
    return LHght>rHght ? LHght :rHght;*/
	}

	public static Node insert(Node root, int data) {
		
		if(root==null){
			return new Node(data);
		}
		
		else{
			Node curr;
			if(data<=root.data){
				curr= insert(root.left,data);
				root.left = curr;
			}else{
				curr= insert(root.right,data);
				root.right = curr;
				
			}
			return root;
		}
		
		
	}
		/*if(root == null){
			return new Node(data);
		}
		else {
			Node cur;
			if(data <= root.data){
				cur = insert(root.left, data);
				root.left = cur;
			}
			else{
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}*/

}
class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
