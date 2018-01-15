package com.dsa.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
/*
Given a Binary tree create Linked Lists of all the nodes at each depth , say if the tree has height k then create k linked lists.
* Create a ArrayList of Linked List Nodes.
* Do the level order traversal using queue(Breadth First Search).
* For getting all the nodes at each level, before you take out a node from queue, store the size of the queue in a variable, say you call it as levelNodes.
* Now while levelNodes>0, take out the nodes and print it and add their children into the queue. add these to a linked list
* After this while loop put a line break and create a new linked list
 */
class LinkedListNode{
    int data;
    LinkedListNode next;
    public LinkedListNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class ListAtDepthBtree {

    ArrayList al = new ArrayList();
    public void levelOrder(Node root){
        int h = height(root);
        for(int i=1;i>=h;i++){
            printLevels(root,i);
            System.out.println("");
        }
    }
    public void printLevels(Node root, int h){
        if(root==null) return;
        if(h==1) System.out.print(" " + root.data);
        else{
            printLevels(root.left,h-1);
            printLevels(root.right,h-1);
        }
    }
    public int height(Node root){
        if (root==null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public void levelOrderQueue(Node root){
        Queue q = new LinkedList();
        int levelNodes =0;
        if(root==null) return;
        q.add(root);
        while(!q.isEmpty()){
            levelNodes = q.size();
            LinkedListNode head = null;
            LinkedListNode curr = null;
            while(levelNodes>0){
                Node n = (Node)q.remove();
                LinkedListNode newNode = new LinkedListNode(n.data);
                if(head==null){
                    head = newNode;
                    curr = newNode;
                }else{
                    curr.next = newNode;
                    curr = curr.next;
                }
                if(n.left!=null) {
                    q.add(n.left);
                }
                if(n.right!=null){
                    q.add(n.right);
                }
                levelNodes--;
            }
            al.add(head);
        }
        display(al);
    }
    public void display(ArrayList al){
        Iterator<LinkedListNode> it = al.iterator();
        while(it.hasNext()){
            LinkedListNode head = it.next();
            //System.out.print("->" + head.data);
            while(head!=null){
                System.out.print("->" + head.data);
                head = head.next;
            }
            System.out.println("");
        }
    }
    public static void main (String[] args) {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        ListAtDepthBtree i  = new ListAtDepthBtree();
        //i.levelOrder(root);
        i.levelOrderQueue(root);
    }
}

