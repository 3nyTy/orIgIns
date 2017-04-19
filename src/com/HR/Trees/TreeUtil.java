package com.HR.Trees;

public interface TreeUtil {
	
	public void bFS(Node root);
	public void inOrderRec(Node root);
	public void inOrder(Node root);
	public void rightViewTree(Node root);
	public void leftViewTree(Node root);
	public void topViewTree(Node root);
	public void verticalOrder(Node root);
	public Node leastCommonAncestor(Node root,Node n1,Node n2);
	public Boolean getAllAncestors(Node root,int target);
	public int shortestPath2Nodes(Node root,Node n1,Node n2);
	public void diamterOfTree(Node root);
	public void chkTreeisBST(Node root);

}
