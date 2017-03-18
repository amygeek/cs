package com.dsa.sort;// Java program for implementation of Bubble Sort

import java.util.Arrays;

class BubbleSort {

    public static final void swap (int[]a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void bubbleSort(int[] arr) {

        int n = arr.length;
        int temp = 0;

        for (int i=0; i < n; i++) {
            for (int j=1; j < (n-i); j++) {
                if(arr[j-1] > arr[j]){
                    swap(arr, j, j-1);
                }

            }
        }

    }

    // Driver method to test above
    public static void main(String[] args) {
        int arr[] = {68, 34, 25, 12, 22, 1, 100, 8};
        System.out.println("before: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("after: " + Arrays.toString(arr));

    }
}
