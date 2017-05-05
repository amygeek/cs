package com.dsa.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort (int[] a, int n) {

        int value, i;
        for (int j = 1; j < n; j++) {
            value = a[j];
            i = j;
            while( i > 0 && a[i-1] > value) {
                a[i] = a[i-1];
                i--;
            }
            a[i] = value;
        }
    }
    public static void main(String[] args) {
        int[] list = {100, 32, 67, 76, 23, 200, 58, 95};
        System.out.println("before: " + Arrays.toString(list));
        insertionSort(list, 8);
        System.out.println("after:  " + Arrays.toString(list));
    }
}