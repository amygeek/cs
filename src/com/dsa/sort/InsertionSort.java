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
        int[] list = {6,4,8,1,3};
        System.out.println("before: " + Arrays.toString(list));
        insertionSort(list, 5);
        System.out.println("after:  " + Arrays.toString(list));
    }
}