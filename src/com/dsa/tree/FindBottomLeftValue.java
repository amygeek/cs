package com.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

//Given a binary tree, find the leftmost value in the last row of the tree.
public class FindBottomLeftValue {

    static int findBottomLeftValue(Node root) {
        
        Queue<Node> queue = new LinkedList<Node>(); // Queue for level order BFS traversal
        List<List<Integer>> list = new LinkedList<List<Integer>>();

        // list stores the reverse level order solution
        // index 0 has the lowest level from left to right
        // so the first element of list is the solution to the problem

        if(root == null) {
            return 0;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();

            for(int i=0; i<levelNum; i++) {

                if(queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().data);
            }
            list.add(0, subList);
        }
        return list.get(0).get(0);
    }

    /*
             1
           /   \
          2      3
        /  \    / \
       4    5  6   7
      / \  / \
     8  9 10 11
             /
            12
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
        root.left.right.right.left = new Node(12);

        int num = findBottomLeftValue(root);
        System.out.println("Bottom Left Value : " + num);  //12
    }
}
