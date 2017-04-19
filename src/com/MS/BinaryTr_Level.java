package com.MS;

public class BinaryTr_Level {

	Node root;
	Leaf mylevel = new Leaf();

	public static void main(String[] args) {
		BinaryTr_Level tree = new BinaryTr_Level();
		tree.root = new Node(12);
		tree.root.left = new Node(5);
		// tree.root.right = new Node(7);
		tree.root.left.left = new Node(3);

		tree.root.left.right = new Node(9);
		tree.root.left.left.left = new Node(1);
		tree.root.left.right.left = new Node(1);
		if (tree.check(tree.root)) {
			System.out.println("Leaf nodes are at sameLevel");
		} else {
			System.out.println("Leaf nodes are not at same level");
		}

	}

	private boolean check(Node root) {

		int level = 0;

		return checkutil(root, level, mylevel);
	}

	private boolean checkutil(Node root, int level, Leaf leafObj) {
		if (root != null) {
			System.out.println(root.data);
		}
		if (root == null)
			return true;
		if (root.right == null && root.left == null) {
			if (leafObj.leaflevel == 0) {

				leafObj.leaflevel = level;
				System.out.println(leafObj.leaflevel + " , " + level);
				return true;
			}
			System.out.println("--------When leaflevel is not  0------");
			System.out.println(leafObj.leaflevel + " , " + level);
			return level == leafObj.leaflevel;

		}

		return checkutil(root.left, level + 1, leafObj)
				&& checkutil(root.right, level + 1, leafObj);
	}

}

class Node {
	int data;
	Node right;
	Node left;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;

	}
}

class Leaf {
	int leaflevel = 0;

}
