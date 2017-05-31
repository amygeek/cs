package com.dsa.linkedlist;

class DoublyLinkedList {

    static Node head;

    static class Node {

        int data;
        Node next, prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    /* Function to reverse a Doubly Linked List */
    void reverse() {

        if (head == null || head.next == null) {
            return;
        }

        Node temp = null;
        Node current = head;

        /* swap next and prev for all nodes of
         doubly linked list */
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        /* Before changing head, check for the cases like empty
         list and list with only one node */
        if (temp != null) {
            head = temp.prev;
        }
    }

    public static Node reverseRecursive(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.prev = head.next;
        head.next = null;

        return newHead;
    }

    /* Function to insert a node at the beginning of the Doubly Linked List */
    void insert(int new_data) {
        /* allocate node */
        Node new_node = new Node(new_data);

        /* since we are adding at the begining,
         prev is always NULL */
        new_node.prev = null;

        /* link the old list off the new node */
        new_node.next = head;

        /* change prev of head node to new node */
        if (head != null) {
            head.prev = new_node;
        }

        /* move the head to point to the new node */
        head = new_node;
    }

    /* Function to print nodes in a given doubly linked list
     This function is same as printList() of singly linked lsit */
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        /* Let us create a sorted linked list to test the functions
         Created linked list will be 10->8->4->2 */
        list.insert(2);
        list.insert(4);
        list.insert(8);
        list.insert(10);
        list.insert(11);


        System.out.println("Original linked list ");
        list.printList(head);

        list.reverse();
        //head = list.reverseRecursive(head);
        System.out.println("");
        System.out.println("The reversed Linked List is ");
        list.printList(head);
    }
}
