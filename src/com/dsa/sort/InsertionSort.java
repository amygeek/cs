package com.dsa.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort (int[] a, int n) {

        int value, idx;
        for (int i = 1; i < n; i++) {
            value = a[i];
            idx = i;
            while( idx > 0 && a[idx-1] > value) {
                a[idx] = a[idx-1];
                idx--;
            }
            a[idx] = value;
        }
    }
    public static void main(String[] args) {
        int[] list = {100, 32, 67, 76, 23, 200, 58, 85};
        System.out.println("before: " + Arrays.toString(list));
        insertionSort(list, 8);
        System.out.println("after:  " + Arrays.toString(list));
    }
}