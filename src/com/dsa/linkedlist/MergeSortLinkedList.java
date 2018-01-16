package com.dsa.linkedlist;

public class MergeSortLinkedList {


    public Node MergeList(Node a, Node b) {
        Node result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.data > b.data) {
            result = b;
            result.next = MergeList(a, b.next);
        } else {
            result = a;
            result.next = MergeList(a.next, b);
        }
        return result;
    }

    public int getLength( Node n ) {
        int count = 0;
        Node current = n;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public Node mergeSort(Node n) {
        Node oldHead = n;
        // find the length of the linkedlist
        int mid = getLength(n) / 2;
        if (n.next == null)
            return n;
        // set one pointer to the beginning of the list and another at the next
        // element after mid
        while (mid - 1 > 0) {
            oldHead = oldHead.next;
            mid--;
        }
        Node newHead = oldHead.next;// make newHead points to the beginning of
        // the second half of the list
        oldHead.next = null;// break the list
        oldHead = n;// make one pointer points at the beginning of the first
        // half of the list
        Node t1 = mergeSort(oldHead);//make recursive calls
        Node t2 = mergeSort(newHead);
        return MergeList(t1, t2); // merge the sorted lists
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
        Node n = new Node(9);
        n.next = new Node(3);
        n.next.next = new Node(4);
        n.next.next.next = new Node(2);
        n.next.next.next.next = new Node(5);
        n.next.next.next.next.next = new Node(1);
        MergeSortLinkedList m = new MergeSortLinkedList();
        m.display(n);
        Node x = m.mergeSort(n);
        System.out.println("\n Sorted List: ");
        m.display(x);
    }
}

