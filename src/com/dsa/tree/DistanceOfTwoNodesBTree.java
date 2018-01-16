package com.dsa.tree;

/**
 * Find the Distance between Two Nodes of a Binary Tree.
 */
public class DistanceOfTwoNodesBTree {

    public int findDistance(Node root, int n1, int n2) {
        int x = Pathlength(root, n1) - 1;
        int y = Pathlength(root, n2) - 1;
        int lcaData = findLCA(root, n1, n2).data;
        int lcaDistance = Pathlength(root, lcaData) - 1;
        return (x + y) - 2 * lcaDistance;
    }

    public int Pathlength(Node root, int n1) {
        if (root != null) {
            int x = 0;
            if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0 || (x = Pathlength(root.right, n1)) > 0) {
                // System.out.println(root.data);
                return x + 1;
            }
            return 0;
        }
        return 0;
    }

    public Node findLCA(Node root, int n1, int n2) {
        if (root != null) {
            if (root.data == n1 || root.data == n2) {
                return root;
            }
            Node left = findLCA(root.left, n1, n2);
            Node right = findLCA(root.right, n1, n2);

            if (left != null && right != null) {
                return root;
            }
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
        }
        return null;
    }

    /*
             1
           /   \
          2      3
        /  \    / \
       4    5  6   7
      / \  / \
     8  9 10 11
    Distance(X, Y) = Distance(root, X) + Distance(root, Y) — 2 * (Distance(root to LCA(X,Y)
    where LCA(X,Y) = Lowest Common Ancestor of X,Y
    In the above example if Distance(8,11) = 4
    Distance(root, 8) = 3
    Distance(root, 11) = 3
    LCA(20, 45) = 2
    Distance(root, 2) = 1
    Distance(20,45) = 3+3 — 2*1 = 4
    */
    public static void main(String[] args) throws java.lang.Exception {
        Node root  = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        DistanceOfTwoNodesBTree i = new DistanceOfTwoNodesBTree();
        System.out.println("Distance between 8 and 11 is : " + i.findDistance(root, 8, 11));
    }
}

