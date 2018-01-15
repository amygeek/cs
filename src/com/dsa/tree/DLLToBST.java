package com.dsa.tree;

/*
Given a sorted dou­bly linked list, con­vert it into Bal­anced binary search tree
Get the size of the Dou­bly Linked list.
Take left n/2 nodes and recur­sively con­struct left subtree
Make the mid­dle node as root and assign the left sub­tree( con­structed in step 2) to root’s left.
Recur­sively con­struct right sub­tree and link it to the the right of root made in step 3.
 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7

         4
       /  \
      2    6
     / \  / \
    1  3 5   7
 */
public class DLLToBST {
    public static DLL head = null;
    public static DLL tail = null;
    public static int size = 0;
    public DLL root;

    public void add(int data) {
        DLL n = new DLL(data);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            head.prev = n;
            n.next = head;
            head = n;
        }
        size++;
    }

    public DLL dLLtoBST(int size) {
        if (size <= 0) {
            return null;
        }
        DLL left = dLLtoBST(size / 2);
        DLL root = head;
        root.prev = left;
        head = head.next;
        root.next = dLLtoBST(size-(size / 2)-1);
        return root;
    }

    public void inOrder(DLL root) {
        if (root != null) {
            inOrder(root.prev);
            System.out.print(" " + root.data);
            inOrder(root.next);
        }
    }

    public void printDLL(DLL head) {
        DLL curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        DLLToBST r = new DLLToBST();
        r.add(9);
        r.add(8);
        r.add(7);
        r.add(6);
        r.add(5);
        r.add(4);
        r.add(3);
        r.add(2);
        r.add(1);
        DLL h = head;
        System.out.println("DLL is : ");
        r.printDLL(h);
        DLL x = r.dLLtoBST(size);
        System.out.println("Inorder traversal of contructed BST");
        r.inOrder(x);
    }
}

class DLL {
    int data;
    DLL next;
    DLL prev;

    public DLL(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
