package com.HR.Trees;

public class BinaryTree {

	Node root;
	BinaryTree(int data){
		root=new Node(data);
	}
	BinaryTree() {
		root=null;
	}
	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.root=new Node(1);
		bt.root.left=new Node(2);
		bt.root.right=new Node(3);
		bt.root.right.right=new Node(8);
		bt.root.right.right.right=new Node(9);
		bt.root.left.left=new Node(4);
		bt.root.left.right=new Node(5);
		bt.root.left.right.left = new Node(6);
		bt.root.left.right.right=new Node(7);
        TreeUtilImpl treeImpl= new TreeUtilImpl();
        System.out.println("BFS is : ");
        treeImpl.bFS(bt.root);
        System.out.println("");
        System.out.println("InOrderWithRec : ");
        treeImpl.inOrderRec(bt.root);
        System.out.println("");
        System.out.println("InOrder : ");
        treeImpl.inOrder(bt.root);
        System.out.println("");
        System.out.println("RightViewOfTree : ");
        treeImpl.rightViewTree(bt.root);
        System.out.println("");
        System.out.println("LeftViewOfTree : ");
        treeImpl.leftViewTree(bt.root);
        System.out.println("");
        System.out.println("TopViewOfTree : ");
        treeImpl.topViewTree(bt.root);
        System.out.println("");
       // System.out.println("LCA Of BT : ");
       // Node temp=treeImpl.leastCommonAncestor(bt.root,new Node(2),new Node(9));
       // System.out.println(temp.data);
        System.out.println("");
        System.out.println("Ancestors of tree : ");
        treeImpl.getAllAncestors(bt.root,9);


	}



}

class Node{

	int data;
	Node left;
	Node right;
	Node(){};
	Node(int data){
		this.data=data;
		left=null;right=null;
	}


}