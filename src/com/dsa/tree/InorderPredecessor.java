
package com.dsa.tree;

public class InorderPredecessor {
	private static Node max(Node root) {
		// we found the max node
		if (root.right == null) {
			return root;
		}
		return max(root.right);
	}

	public static Node predecessor(Node root, Node node) {
		// Node has left subtree
		if (node.left != null)
			return max(node.left);

		// No left subtree
		Node predecessor = null;
		// Start from root and search for predecessor down the tree
		while (root != null) {
			if (node.data == root.data) {
				// by now we might found our predecessor
				break;
			} else if (node.data < root.data) {
				root = root.left;
			} else if (node.data > root.data) {
				predecessor = root;
				root = root.right;
			}
		}
		return predecessor;
	}

	public static void main(String[] args) {
		// root level 0
		Node A = Node.createNode(100);
		// Level 1
		Node B = Node.createNode(50);
		Node C = Node.createNode(150);
		// Level 2
		Node D = Node.createNode(25);
		Node E = Node.createNode(75);
		Node F = Node.createNode(125);
		Node G = Node.createNode(175);
		// Level 3
		Node H = Node.createNode(120);
		Node I = Node.createNode(140);
		Node J = Node.createNode(160);
		Node K = Node.createNode(190);

		// connect Level 0 and 1
		A.left = B;
		A.right = C;
		// connect level 1 and level 2
		B.left = D;
		B.right = E;
		C.left = F;
		C.right = G;
		// Connect level 2 and level 3
		F.left = H;
		F.right = I;
		G.left = J;
		G.right = K;

		Node predecessor = InorderPredecessor.predecessor(A, H);
		System.out.printf("Inorder predecessor of Node %d is %d\n", H.data, predecessor.data);

		predecessor = InorderPredecessor.predecessor(A, E);
		System.out.printf("Inorder predecessor of Node %d is %d\n", E.data, predecessor.data);

		predecessor = InorderPredecessor.predecessor(A, F);
		System.out.printf("Inorder predecessor of Node %d is %d\n", F.data, predecessor.data);

		predecessor = InorderPredecessor.predecessor(A, C);
		System.out.printf("Inorder predecessor of Node %d is %d\n", C.data, predecessor.data);

		predecessor = InorderPredecessor.predecessor(A, A);
		System.out.printf("Inorder predecessor of Node %d is %d\n", A.data, predecessor.data);
	}
}
