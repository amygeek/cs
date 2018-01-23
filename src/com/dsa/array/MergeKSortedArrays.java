package com.dsa.array;

import java.util.Arrays;

/*
Objective: Given k sorted array, write an algorithm to merge Them into One sorted array.

Example :

int[][] A = new int[5][];

A[0] = new int[] { 1, 5, 8, 9 };
A[1] = new int[] { 2, 3, 7, 10 };
A[2] = new int[] { 4, 6, 11, 15 };
A[3] = new int[] { 9, 14, 16, 19 };
A[4] = new int[] { 2, 4, 6, 9 };

Output:
[1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 9, 9, 9, 10, 11, 14, 15, 16, 19]
O(nkLogk)
Create an result[] of size n*k.
Create Min-Heap of type HeapNode.( HeapNode- Every Node will store the data and the list no from which it belongs).
Now take one element from each of the K list and create HeapNode object and insert into min-Heap.
Extract the minimum Node from the min-Heap, insert the data into result array.
The extracted node will also contain the list to which it belongs, insert the next element from that list into min-Heap.
If any point of time any list gets over, insert +∞ into min-Heap.
Keep repeating until all the K list gets over.
 */
public class MergeKSortedArrays {

    public int size;
    public HeapNode[] Heap;
    public int position;
    int[] result;

    public MergeKSortedArrays(int k) {
        this.size = k;
        Heap = new HeapNode[k + 1]; // size+1 because index 0 will be empty
        position = 0;
        Heap[0] = new HeapNode(0, -1); // put some junk values at 0th index node
    }

    public int[] merge(int[][] arr, int k, int n) {
        int nk = n * k;
        result = new int[nk];
        int count = 0;

        int[] ptrs = new int[k];  // create index pointer for every list.


        for (int i = 0; i < ptrs.length; i++) {
            ptrs[i] = 0;
        }
        for (int i = 0; i < k; i++) {
            if (ptrs[i] < n) {
                insert(arr[i][ptrs[i]], i); // insert the element into heap
            } else {
                insert(Integer.MAX_VALUE, i); // if any of this list burns out, insert +infinity
            }

        }
        while (count < nk) {
            HeapNode h = extractMin(); // get the min node from the heap.
            result[count] = h.data; // store node data into result array
            ptrs[h.listNo]++; // increase the particular list pointer
            if (ptrs[h.listNo] < n) { // check if list is not burns out
                insert(arr[h.listNo][ptrs[h.listNo]], h.listNo); // insert the next element from the list
            } else {
                insert(Integer.MAX_VALUE, h.listNo); // if any of this list burns out, insert +infinity
            }
            count++;
        }
        return result;
    }

    public void insert(int data, int listNo) {
        if (position == 0) { // check if Heap is empty
            Heap[position + 1] = new HeapNode(data, listNo); // insert the first element in heap
            position = 2;
        } else {
            Heap[position++] = new HeapNode(data, listNo);// insert the element to the end
            bubbleUp(); // call the bubble up operation
        }
    }

    public HeapNode extractMin() {
        HeapNode min = Heap[1]; // extract the root
        Heap[1] = Heap[position - 1]; // replace the root with the last element in the heap
        Heap[position - 1] = null; // set the last Node as NULL
        position--; // reduce the position pointer
        sinkDown(1); // sink down the root to its correct position
        return min;
    }

    public void sinkDown(int k) {
        int smallest = k;
        // check which is smaller child , 2k or 2k+1.
        if (2 * k < position && Heap[smallest].data > Heap[2 * k].data) {
            smallest = 2 * k;
        }
        if (2 * k + 1 < position && Heap[smallest].data > Heap[2 * k + 1].data) {
            smallest = 2 * k + 1;
        }
        if (smallest != k) { // if any if the child is small, swap
            swap(k, smallest);
            sinkDown(smallest); // call recursively
        }

    }

    public void swap(int a, int b) {
        // System.out.println("swappinh" + mH[a] + " and " + mH[b]);
        HeapNode temp = Heap[a];
        Heap[a] = Heap[b];
        Heap[b] = temp;
    }

    public void bubbleUp() {
        int pos = position - 1; // last position
        while (pos > 0 && Heap[pos / 2].data > Heap[pos].data) { // check if its parent is greater.
            HeapNode y = Heap[pos]; // if yes, then swap
            Heap[pos] = Heap[pos / 2];
            Heap[pos / 2] = y;
            pos = pos / 2; // make pos to its parent for next iteration.
        }
    }

    public static void main(String[] args) {
        
        int[][] arr = new int[5][];
        arr[0] = new int[] { 1, 5, 8, 9 };
        arr[1] = new int[] { 2, 3, 7, 10 };
        arr[2] = new int[] { 4, 6, 11, 15 };
        arr[3] = new int[] { 9, 14, 16, 19 };
        arr[4] = new int[] { 2, 4, 6, 9 };
        MergeKSortedArrays m = new MergeKSortedArrays(arr.length);
        int[] op = m.merge(arr, arr.length, arr[0].length);
        System.out.println(Arrays.toString(op));
    }

}

