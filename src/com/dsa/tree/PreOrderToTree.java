package com.dsa.tree;
import java.util.Stack;

public class PreOrderToTree {
    public int pIndex = 0;
    /*
    Construct Binary Search Tree from a given Preorder Traversal Recursion
     */
    public Node preOrderToTreeRec(int[] preOrder, int data, int min, int max) {

        if (pIndex < preOrder.length) {
            if (preOrder[pIndex] > min && preOrder[pIndex] < max) {
                Node root = new Node(data);
                pIndex++;
                if (pIndex < preOrder.length) {
                    // nodes lies between min and data will create left subtree
                    root.left = preOrderToTreeRec(preOrder, preOrder[pIndex], min, data);
                    // nodes lies between data and max will create right subtree
                    root.right = preOrderToTreeRec(preOrder, preOrder[pIndex], data, max);
                }
                return root;
            }
        }
        return null;
    }

    /*
     Construct Binary Search Tree from a given Preorder Traversal Using Stack (Without Recursion)

     Example: int[] preOrder = { 10, 5, 2, 7, 15, 12, 20 };
     Use Stack.
     First element in the preorder[] will definitely be the root, which is 20 here.
     Create a node with data 20 and push it in Stack.
     Now take the next element (say data) from the preorder sequence.
     If data is greater than the top item in the stack then keep popping out the nodes from the stack, keep storing it in temp node till the top node in stack is less than the data.
     create a node with data and add it to the right of temp node and push the temp node to stack.
     If data is less than the top item in the stack then create a node with data and add it to the left of top node in stack and push it in the stack.
     Repeat the above two steps till all the elements in preorder[] is over.
     return the root
     */
    public Node preOrderToTreeIte(int[] preOrder) {
        Stack<Node> s = new Stack<Node>();
        Node root = new Node(preOrder[0]);
        s.add(root);
        for (int i = 1; i < preOrder.length; i++) {
            Node x = null;
            while (!s.isEmpty() && preOrder[i] > s.peek().data) {
                x = s.pop();
            }
            if (x != null) {
                x.right = new Node(preOrder[i]);
                s.push(x.right);
            } else {
                s.peek().left = new Node(preOrder[i]);
                s.push(s.peek().left);
            }
        }
        return root;
    }

    public void displayTree(Node root) {
        if (root != null) {
            displayTree(root.left);
            System.out.print(" " + root.data);
            displayTree(root.right);
        }
    }

    public static void main(String args[]) {
        PreOrderToTree p = new PreOrderToTree();
        int[] preOrder = { 20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40 };
        Node root = p.preOrderToTreeRec(preOrder, preOrder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Construct Tree recursively: : ");
        p.displayTree(root);

        System.out.println(" ");
        System.out.println("Construct Tree iteratively: ");
        root = p.preOrderToTreeIte(preOrder);
        p.displayTree(root);
    }
}

