package com.dsa.linkedlist;

/**
 * Created by amyhu on 5/30/17.
 */
public class ReverseEvenNodes {

    // Helper function to merge two lists.
    public static Node merge_alternating(Node list1, Node list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }



        // Original: 1,2,3,4,5
        // list1: 1,3,5
        // list2: 4,2
        // Merged: 1,4,3,2,5

        Node head = list1;

        while (list1.next != null && list2 != null) {
            Node temp = list2;
            list2 = list2.next;

            temp.next = list1.next;
            list1.next = temp;
            list1 = temp.next;
        }

        if (list1.next == null) {
            list1.next = list2;
        }

        return head;
    }

    public static Node reverse_even_nodes(
            Node head) {

        // Let's extract even nodes from the existing
        // list and create a new list consisting of 
        // even nodes. We will push the even nodes at
        // head since we want them to be in reverse order.

        Node curr = head;
        Node list_even = null;

        while (curr != null &&
                curr.next != null) {
            Node even = curr.next;
            curr.next = even.next;

            // Push at the head of new list.
            even.next = list_even;
            list_even = even;

            curr = curr.next;
        }

        // Now, merge the two lists
        // Original: 1,2,3,4,5
        // Modified original: 1,3,5
        // List_even: 4,2
        // Merged: 1,4,3,2,5

        return merge_alternating(head, list_even);
    }

    public void display(Node head) {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }

        System.out.print("null");
    }

    public static void main(String args[]) {
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        a.next.next.next = new Node(4);
        a.next.next.next.next = new Node(5);
//        a.next.next.next.next.next = new Node(6);
        ReverseEvenNodes n = new ReverseEvenNodes();
        n.display(a);
        Node x = n.reverse_even_nodes(a);
        System.out.println("\n Reverse Even Nodes: ");
        n.display(x);
    }


}
