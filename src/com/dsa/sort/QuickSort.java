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
        int i = low;
        for (int j=low; j<high; j++ ) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, high);
        return  i;
    }
    public static int randomPartition (int[] a, int low, int high) {
        Random rand = new Random();
        int num = low + rand.nextInt(high - low);
        swap(a, num, high);
        int pivot = a[high];
        int i = low;
        for (int j=low; j<high; j++ ) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, high);
        return  i;
    }

    public static void sort (int[] a, int low, int high) {
        if (low < high) {
            int p = randomPartition(a, low, high);
            sort(a, low, p - 1 );
            sort(a, p + 1, high);
        }

    }
    public static void main(String[] args) {
        int[] list = {3, 2, 1, 6, 8, 5};
        System.out.println("before: " + Arrays.toString(list));
        sort(list, 0, list.length - 1);
        System.out.println("after:  " + Arrays.toString(list));
    }
}