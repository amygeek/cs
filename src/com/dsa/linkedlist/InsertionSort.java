package com.dsa.linkedlist;

/**
 * Created by amyhu on 5/29/17.
 */
/*
public class InsertionSort {

    public static LinkedList sorted_insert(
            LinkedList head,
            LinkedList node) {

        if (node == null) {
            return head;
        }

        if (head == null || node.data <= head.data) {
            node.next = head;
            return node;
        }

        LinkedList curr = head;

        while (curr.next != null && (curr.next.data < node.data)) {

            curr = curr.next;
        }

        node.next = curr.next;
        curr.next = node;

        return head;
    }

    public static LinkedList insertion_sort(LinkedList head) {

        LinkedList sorted = null;
        LinkedList curr = head;

        while (curr != null) {

            LinkedList temp = curr.next;

            sorted = sorted_insert(sorted, curr);

            curr = temp;
        }

        return sorted;
    }
}
*/