package com.dsa.tree;

/*
Given a binary tree, find the diameter of it.

Diameter of tree is defined as A longest path or route between any two nodes in a tree. 
The path may or may not for through the root.

Time Complexity O(N).
finding the height of tree and diameter in the same iteration.
Every node will return the two information in the same iteration , height of that node and diameter of tree with respect to that node.
 */
public class DiameterOfTree {
    int diameter = 0;

    // here in improved solution, we calculate the height and diameter for every
    // node in same iteration
    // every Node will return 2 values, diameter and height wrt to the
    // particular node
    public int[] Diameter(Node root) {
        int DandH[] = { 0, 0 }; // initialize the height (DandH[0]) and diameter
        // as 0 (DandH[1])
        if (root != null) {

            int[] leftResult = Diameter(root.left);
            int[] rightResult = Diameter(root.right);

            int height = Math.max(leftResult[0], rightResult[0]) + 1;
            int leftDiameter = leftResult[1];
            int rightDiameter = rightResult[1];
            int rootDiameter = leftResult[0] + rightResult[0] + 1;
            int finalDiameter = getMax(leftDiameter, rightDiameter,
                    rootDiameter);
            // prepare the DandH[]
            DandH[0] = height; // update the height
            DandH[1] = finalDiameter;
            return DandH;
        }
        return DandH;
    }

    public int getMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.left.right = new Node(7);
        root.left.left.left = new Node(8);

        DiameterOfTree d = new DiameterOfTree();
        System.out.println("Diameter of Tree " + d.Diameter(root)[1]);
    }
}


