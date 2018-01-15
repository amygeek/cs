package com.dsa.tree;

public class LowestCommonAncestorBST {
    
    public Node LowestCommonAncestor(Node root, Node n1, Node n2) {

        if (root == null) {
            return null;
        }
        // If root>n1 and root>n2 then lowest common ancestor will be in left subtree.
        if (root.data > n1.data && root.data > n2.data) {
            return LowestCommonAncestor(root.left, n1, n2);

        } else if (root.data <= n1.data && root.data < n2.data) {
            // If root<n1 and root<n2 then lowest common ancestor will be in right subtree.
            return LowestCommonAncestor(root.right, n1, n2);
        }
        // if I am here that means i am at the root which is lowest common ancestor
        return root;
    }

    public Node LowestCommonAncestor2(Node root, Node n1, Node n2) {
        while (root != null) {

            // If root>n1 and root>n2 then lowest common ancestor will be in left subtree.
            if (root.data > n1.data && root.data > n2.data) {
                root = root.left;

            } else if (root.data <= n1.data && root.data < n2.data) {
                // If root<n1 and root<n2 then lowest common ancestor will be in right subtree.
                root = root.right;
            } else {
                // if I am here that means i am at the root which is lowest common ancestor
                return root;
            }
        }
        return root;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        Node n1 = new Node(5);
        root.left.left = n1;
        root.left.right = new Node(13);
        Node n2 = new Node(14);
        root.left.right.right = n2;
        root.left.right.left = new Node(12);

        LowestCommonAncestorBST i = new LowestCommonAncestorBST();
        System.out.println("Recursive-Lowest Common Ancestor of Nodes "
                + n1.data + " and " + n2.data + " is : "
                + i.LowestCommonAncestor(root, n1, n2).data);

        Node x = i.LowestCommonAncestor2(root, n1, n2);
        System.out.println("Iterative-Lowest Common Ancestor of Nodes "
                + n1.data + " and " + n2.data + " is : " + x.data);

    }
}

