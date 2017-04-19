package com.HR.Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class TreeUtilImpl implements TreeUtil {

	@Override
	public void bFS(Node root) {

		Queue<Node> queue = new LinkedList<Node>();
		Node temp;
		queue.add(root);
		while (!queue.isEmpty()) {
			temp = (Node) queue.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}

		}

	}

	@Override
	public void inOrderRec(Node root) {
		if (root == null)
			return;
		inOrderRec(root.left);
		System.out.print(root.data + " ");
		inOrderRec(root.right);

	}

	@Override
	public void inOrder(Node root) {
		Stack<Node> st = new Stack<Node>();
		while (true) {
			while (root != null) {
				st.push(root);
				root = root.left;
			}
			if (st.isEmpty())
				break;
			root = (Node) st.pop();

			System.out.print(root.data + " ");
			root = root.right;

		}

	}

	@Override
	public void rightViewTree(Node root) {
		//int level=1;
		Queue<Node> que = new LinkedList<Node>();
		que.add(root);
		//que.add(null);
		System.out.print(root.data+" ");
		while(!que.isEmpty()){
			root=que.poll();
			/*if(root==null){
				if(!que.isEmpty()){
					que.add(null);
				}
				level++;
			}*/
			if(root.left!=null){
				que.add(root.left);
				
			}
			if(root.right!=null){
				que.add(root.right);
				System.out.print(root.right.data+" ");
			}
			
		}
		
		
		
		
		

	}

	@Override
	public void leftViewTree(Node root) {
		Queue<Node> que = new LinkedList<Node>();
		que.add(root);
		//que.add(null);
		System.out.print(root.data+" ");
		while(!que.isEmpty()){
			root=que.poll();
			/*if(root==null){
				if(!que.isEmpty()){
					que.add(null);
				}
				level++;
			}*/
			if(root.left!=null){
				que.add(root.left);
				System.out.print(root.left.data+" ");
				
			}
			if(root.right!=null){
				que.add(root.right);
				
			}
			
		}
		
		


	}

	@Override
	public void topViewTree(Node root) {
		/*Stack<Node> st = new Stack<Node>();
		Node temp=root;
		while(temp!=null){
			st.push(temp);
			//System.out.print(temp.data + " ");
			temp=temp.left;
		}
		while(st.size()!=0){
			System.out.print(st.pop().data+" ");
		}
		System.out.println(root.data+" ");
		Node rightRoot=root.right;
		while(rightRoot!=null){
			System.out.print(rightRoot.data+" ");
			rightRoot=rightRoot.right;
		}*/
		//Second Approach
		Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		Map<Integer,Integer> cpyHm = new TreeMap<Integer,Integer>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		int rc=0;
		hm.put(root.data,rc);
		cpyHm.put(hm.get(root.data),root.data);
		while(!queue.isEmpty()){
			root=queue.poll();
			if(root.left!=null){
			hm.put(root.left.data,hm.get(root.data)-1);
			queue.add(root.left);

				if(!cpyHm.containsKey(hm.get(root.left.data))){
				
					cpyHm.put(hm.get(root.left.data), root.left.data);
				}
			}
			if(root.right!=null){
				hm.put(root.right.data, hm.get(root.data)+1);
				queue.add(root.right);

				if(!cpyHm.containsKey(hm.get(root.right.data))){
					cpyHm.put(hm.get(root.right.data), root.right.data);
				}
			}
		}
		
		for(Map.Entry<Integer, Integer> map:cpyHm.entrySet()){
			System.out.print(map.getValue()+" ");
			
		}

	}

	@Override
	public Node leastCommonAncestor(Node root,Node n1,Node n2) {
		if(root==null) return null;
		if(root==n1 || root==n2) return root;
		Node left=leastCommonAncestor(root.left, n1, n2);
		Node right = leastCommonAncestor(root.right, n1, n2);
		//if(left==null && right ==null) return null;
		if(left!=null && right !=null) return root;
		
		
		return left != null?left:right ;
		
		
	}

	@Override
	public Boolean getAllAncestors(Node root,int target) {

		if(root==null) return false;
		if(root.data==target) return true;
		if(getAllAncestors(root.left, target)||getAllAncestors(root.right, target)){
			System.out.print(root.data+" ");
			return true;
			
		}
		
		return false;
	}

	@Override
	public int shortestPath2Nodes(Node root,Node n1, Node n2) {
        int n1Dist = getPath(root,n1);
        int n2Dist = getPath(root, n2);
        int lcsDist = getPath(root,leastCommonAncestor(root, n1, n2));
        return n1Dist + n2Dist - (2*lcsDist);
	}

	private int getPath(Node root, Node n) {
		int level=1;
		return getPathLevel(root,n,level);
        
	}

	private int getPathLevel(Node root, Node n, int level) {
        if(root==null) return 0; 
		if(root.data==n.data) return level;
		int leftLevel = getPathLevel(root.left, n, level+1);
		if (leftLevel!=0) return leftLevel;
		leftLevel = getPathLevel(root.right, n, leftLevel+1);
	
		return leftLevel;

	}

	@Override
	public void diamterOfTree(Node root) {

	}

	@Override
	public void verticalOrder(Node root) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chkTreeisBST(Node root) {
		// TODO Auto-generated method stub
		
	}

}
