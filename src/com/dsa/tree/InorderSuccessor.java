package com.dsa.tree;

public class InorderSuccessor  {

    //Function to find some data in the tree
    public static Node find(Node root, int data) {
        if(root == null) {
            return null;
        } else if(root.data == data) {
            return root;
        } else if(root.data < data) {
            return find(root.right, data);
        } else {
            return find(root.left, data);
        }
    }

    //Function to find Node with minimum value in a BST
    public static Node findMin( Node root) {
        if(root == null) return null;
        while(root.left != null)
            root = root.left;
        return root;
    }

    //Function to find Inorder Successor in a BST
    public static Node getSuccessor(Node root, int data) {
        // Search the Node - O(h)
        Node current = find(root,data);
        
        if(current == null) {
            return null;
        }

        //Case 1: Node has right subtree
        if(current.right != null) {  
            return findMin(current.right); // O(h)
        
        } else {   //Case 2: No right subtree  - O(h)
            
            Node successor = null;
            Node ancestor = root;
            while(ancestor != current) {
                if(current.data < ancestor.data) {
                    successor = ancestor; // so far this is the deepest node for which current node is in left
                    ancestor = ancestor.left;
                }
                else
                    ancestor = ancestor.right;
            }
            return successor;
        }
    }

    //Function to visit nodes in Inorder
    public static void Inorder(Node root) {
        if(root == null) return;

        Inorder(root.left);                 //Visit left subtree
        System.out.print(root.data + " ");    //Print data
        Inorder(root.right);                // Visit right subtree
    }

    // Function to insert Node in a Binary Search Tree
    public static Node insert( Node root, int data ) {
        if(root == null) {
            root = new Node();
            root.data = data;
            root.left = root.right = null;
        } else if(data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert( root.right, data );
        }
            
        return root;
    }

    public static void main(String[] args) {
	/*Code To Test the logic
	  Creating an example tree
                5
			   / \
			  3   10
			 / \   \
			1   4   11
    */
        Node root = null;
        root = insert(root,5);
        root = insert(root,10);
        root = insert(root,3);
        root = insert(root,4);
        root = insert(root,1);
        root = insert(root,11);

        //Print Nodes in Inorder
        System.out.println("Inorder Traversal: ");
        Inorder(root);
        System.out.println(" ");

        // find Inorder successor of some node.
        Node successor = getSuccessor(root, 4);

        if(successor == null) {
            System.out.println("No successor Found");
        } else {
            System.out.println(4 + " -> "  + successor.data);
        }

//        successor = getSuccessor(root, 3);
//        System.out.println(3 + " -> "  + successor.data);
//        successor = getSuccessor(root, 4);
//        System.out.println(4 + " -> "  + successor.data);
//        successor = getSuccessor(root, 5);
//        System.out.println(5 + " -> "  + successor.data);
//        successor = getSuccessor(root, 10);
//        System.out.println(10 + " -> "  + successor.data);



    }

}




