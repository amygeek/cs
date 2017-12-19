package com.dsa.sort;// Java program for implementation of Bubble Sort

import java.util.Arrays;

class BubbleSort {

    public static final void swap (int[]a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void bubbleSort(int[] arr, int n) {

        for (int i=0; i < n - 1; i++) {
            for (int j=0; j < n - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j+1);
                }

            }
        }

    }

    public static void bubbleSortRec ( int[] arr, int n) {

        for ( int j=0; j< n-1; j++) {
            if (arr[j] > arr[j+1]) {
                swap(arr, j, j+1);
            }
        }
        if ( n - 1 > 1 ) {
            bubbleSortRec(arr, n - 1);
        }
    }

    // Driver method to test above
    public static void main(String[] args) {
        int arr[] = {68, 34, 25, 12, 22, 1, 100, 8};
        System.out.println("before: " + Arrays.toString(arr));
        bubbleSortRec(arr, arr.length);
        System.out.println("after: " + Arrays.toString(arr));

    }
}
