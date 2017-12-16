package com.dsa.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static final void swap (int[]a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static int partition (int[] a, int low, int high) {
        int pivot = a[high];
        int pIndex = low;
        for (int j=low; j<high; j++ ) {
            if (a[j] <= pivot) {
                swap(a, pIndex, j);
                pIndex++;
            }
        }
        swap(a, pIndex, high);
        return  pIndex;
    }
    public static int randomPartition (int[] a, int low, int high) {

        Random rand = new Random();
        int num = low + rand.nextInt(high - low);
        swap(a, num, high);

        int pivot = a[high];
        int pIndex = low;
        for (int j=low; j<high; j++ ) {
            if (a[j] <= pivot) {
                swap(a, pIndex, j);
                pIndex++;
            }
        }
        swap(a, pIndex, high);
        return  pIndex;
    }

    public static void sort (int[] a, int low, int high) {

        if (low >= high) {
            return;
        }

        int p = partition(a, low, high);
        sort(a, low, p - 1 );
        sort(a, p + 1, high);
    }

    // Sorts arr[low.....high] using iterative QuickSort
    public static void quickSortIterative(int a[], int low, int high) {
        // create auxiliary stack
        int stack[] = new int[high - low + 1];

        // initialize top of stack
        int top = -1;

        // push initial values in the stack
        stack[++top] = low;
        stack[++top] = high;

        // keep popping elements until stack is not empty
        while (top >= 0)
        {
            // pop h and l
            high = stack[top--];
            low = stack[top--];

            // set pivot element at it's proper position
            int p = partition(a, low, high);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if ( p-1 > low ) {
                stack[ ++top ] = low;
                stack[ ++top ] = p - 1;
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if ( p+1 < high )
            {
                stack[ ++top ] = p + 1;
                stack[ ++top ] = high;
            }
        }
    }
    public static void main(String[] args) {
        int[] list = {8, 2, 1, 6, 28, 5};
        System.out.println("before: " + Arrays.toString(list));
        quickSortIterative(list, 0, list.length - 1);
        System.out.println("after:  " + Arrays.toString(list));
    }
}