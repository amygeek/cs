package com.dsa.tree;

/*
Find the Lowest Common Ancestor of two given nodes in a Binary Tree
In a given binary tree, The lowest common ancestor of two nodes n1 and n2 will be a node X
such that node X will be the lowest node who has n1 and n2 as its descendants.

Start will the root.
If root matches with any of the given nodes (n1, n2) then return root as Lowest Common Ancestor.
IF not then make recursive callas to left subtree and right subtree for the search of the nodes n1 and n2.
Now both the nodes (n1 and n2) will be in the left subtree of the current visiting node OR it will be in the right subtree of current visiting OR n1 and n2 will be in each side of current visiting node.
If you find a node which has one node in its left subtree and one node in its right subtree than this node will be our lowest common ancestor.
If both the nodes (n1 and n2) will be in the left subtree of the current visiting node then go left
If both the nodes (n1 and n2) will be in the right subtree of the current visiting node then go right.
 */
public class LowestCommonAncestorBT {

    public Node findLCA(Node root, Node n1, Node n2){

        if(root==null){
            return null;
        }else{

            if(root.data==n1.data||root.data==n2.data){
                return root;
            }
            Node left = findLCA(root.left, n1, n2);
            Node right = findLCA(root.right, n1, n2);

            if ( left!=null && right!=null){
                return root;
            }
            if(left!=null){
                return left;
            }else if(right!=null){
                return right;
            }
            return null;
        }
    }
    /*
              1
            /   \
           2      3
         /  \    / \
        4    5  6   7
       / \  / \
      8  9 10 11

     */
    public static void main (String[] args) throws java.lang.Exception {
        Node root  = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        Node n3 = new Node(5);
        root.left.right = n3;
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node n1 = new Node(8);
        root.left.left.left = n1;
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        Node n2 = new Node(11);
        root.left.right.right = n2 ;

        LowestCommonAncestorBT i = new LowestCommonAncestorBT();
        Node x = i.findLCA(root,n1,n2);
        //Lowest Common Ancestor (8, 30 ) is 2
        System.out.println("Lowest Common Ancestor ("+n1.data+", "+ n2.data +" ) is " + x.data);
        x = i.findLCA(root,n2,n3);
        //Lowest Common Ancestor (30, 5 ) is 5
        System.out.println("Lowest Common Ancestor ("+n2.data+", "+ n3.data +" ) is " + x.data);
    }
}

