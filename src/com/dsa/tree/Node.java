package com.dsa.tree;

public class Node {
	public int data;
	public Node left;
	public Node right;

	public Node(int num) {
		data = num;
		left = null;
		right = null;
	}

	public Node() {
		left = null;
		right = null;
	}

	public static Node createNode(int num) {

		return new Node(num);
	}
    public Node find(int d) {
        if (d == data) {
            return this;
        } else if (d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }
	private static Node createMinimalBST(int arr[], int start, int end){
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node n = new Node(arr[mid]);
		n.left = (createMinimalBST(arr, start, mid - 1));
		n.right = (createMinimalBST(arr, mid + 1, end));
		return n;
	}

	public static Node createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}
}