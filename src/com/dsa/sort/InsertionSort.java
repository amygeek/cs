
package com.dsa.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort (int[] a, int n) {

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i;
            while( j > 0 && a[j-1] > value) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = value;
        }
    }

    public static void insertionSortRec ( int[] a, int i, int n) {
        int value = a[i];
        int j = i;

        while ( j > 0 && a[j-1] > value) {
            a[j] = a[j-1];
            j--;
        }
        a[j] = value;

        if (i + 1 < n ) {
            insertionSortRec(a, i + 1, n);
        }

    }

    public static void main(String[] args) {
        int[] list = {6,4,8,1,3,5,7};
        System.out.println("before: " + Arrays.toString(list));
        insertionSortRec(list, 1, list.length);
        System.out.println("after:  " + Arrays.toString(list));
    }
}