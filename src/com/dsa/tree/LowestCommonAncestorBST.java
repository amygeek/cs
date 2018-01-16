package com.dsa.tree;

/**
 1. Start will the root.
 2. If root>n1 and root>n2 then lowest common ancestor will be in left subtree.
 3. If root<n1 and root<n2 then lowest common ancestor will be in right subtree.
 4. If Step 2 and Step 3 is false then we are at the root which is lowest common ancestor, return it.
 */
public class LowestCommonAncestorBST {

    //using postOrder traversal
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
    /*
             15
            /  \
           10  20
          /  \
         5   13
            /  \
           12  14

        Lowest Common Ancestor of Nodes 5 and 14 is : 10
     */
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

//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        Node root = Node.createMinimalBST(array);
//        Node n1 = root.find(6);
//        Node n2 = root.find(9);

        LowestCommonAncestorBST i = new LowestCommonAncestorBST();
        System.out.println("Recursive-Lowest Common Ancestor of Nodes "
                + n1.data + " and " + n2.data + " is : "
                + i.LowestCommonAncestor(root, n1, n2).data);

        Node x = i.LowestCommonAncestor2(root, n1, n2);
        System.out.println("Iterative-Lowest Common Ancestor of Nodes "
                + n1.data + " and " + n2.data + " is : " + x.data);

    }
}

