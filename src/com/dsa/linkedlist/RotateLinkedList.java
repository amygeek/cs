package com.dsa.linkedlist;

/**
 * Created by amyhu on 5/30/17.
 */
public class RotateLinkedList {

    private static int find_length(Node head) {
        int len = 0;

        while (head != null) {
            ++len;
            head = head.next;
        }

        return len;
    }

    private static int adjust_rotations_needed(int n, int len) {
        // If n is positive then number of rotations performed is from right side
        // and if n is negative then number of rotations performed from left side
        // Let's optimize the number of rotations.
        // Handle case if 'n' is a negative number.
        n = n % len;

        if (n < 0) {
            n = n + len;
        }

        return n;
    }

    public static Node rotate_list(Node head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        int len = find_length(head);

        // If n (number of rotations required) is bigger than
        // length of linked list or if n is negative then
        // we need to adjust total number of rotations needed
        n = adjust_rotations_needed(n, len);

        if (n == 0) {
            return head;
        }

        // Find the start of rotated list.
        // If we have 1,2,3,4,5 where n = 2,
        // 4 is the start of rotated list.
        int rotations_count = len - n - 1;
        Node temp = head;

        while (rotations_count > 0) {
            rotations_count--;
            temp = temp.next;
        }

        // After the above loop temp will be pointing
        // to one node prior to rotation point
        Node new_head = temp.next;

        // Set new end of list.
        temp.next = null;

        // Iterate to the end of list and 
        // link that to original head.
        temp = new_head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        return new_head;
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
        RotateLinkedList n = new RotateLinkedList();
        n.display(a);
        Node x = n.rotate_list(a, 2);
        System.out.println("\n Rotate LinkedList: ");
        n.display(x);
    }
}
