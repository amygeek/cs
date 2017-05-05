package com.dsa.linkedlist;

class LinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Function to reverse the linked list */
    public Node reverseIterative(Node head) {

        // no need to reverse if head is null
        // or there is only 1 node.
        if (head == null || head.next == null) {
            return head;
        }

        //set prev and next to null at first
        Node prev = null;
        Node next = null;

        Node current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static Node reverseRecursive(Node head) {
        //no need to reverse if head is
        //null or there is only 1 node.
        if (head == null || head.next == null) {
            return head;
        }

        //EX: original head -> 7 -> 14 -> 21 -> 28 -> null
        //when the next reverseRecursive is done, the head will point at 28 which will exit the recursive call
        Node reversedList = reverseRecursive(head.next);

        //head.next.next is null. Setting head.next.next to head will trigger the recursive call again
        //inserting the current node as the next of the last node will create the new reversed linked list.
        //Then return the head of the new linked list.
        head.next.next = head;
        head.next = null;
        return reversedList;
    }

    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // prints content of double linked list
    void printListReverse(Node node) {

        if ( node == null ) {
            return;
        }

        printListReverse(node.next);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(7);
        list.head.next = new Node(14);
//        list.head.next.next = new Node(21);
//        list.head.next.next.next = new Node(28);

        System.out.println("Given Linked list");
        list.printList(head);

//        head = list.reverseIterative(head);
//        System.out.println("");
//        System.out.println("Reversed linked list Iterative");
//        list.printList(head);

        head = list.reverseRecursive(head);

        System.out.println("Reversed linked list Recursively ");
        list.printList(head);

        System.out.println("");
        System.out.println("Print Linked List reversely");
        list.printListReverse(head);
    }
}
