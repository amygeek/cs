package com.dsa.tree;
import java.util.Stack;

public class PreOrderToTree {
    public int pIndex = 0;

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

