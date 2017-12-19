package com.dsa.sort;// This program implements the merge sort algorithm for
// arrays of integers.

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] list = {6,4,8,1,3,5,7};
        System.out.println("before: " + Arrays.toString(list));
        sortIterative(list, 0, list.length - 1 );
        System.out.println("after:  " + Arrays.toString(list));
    }

    public static int min ( int a, int b) {
        return (a > b) ? b : a;
    }

    public static void sort(int[] a, int low, int high) {

        if(low >= high){
            return;
        }

        int mid = (low + high) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);

        merge(a, low, high);

    }

    public static void sortIterative( int[] a, int low, int high) {

        for (int m=1; m< high - low + 1; m = 2*m) {

            for (int i = low; i< high; i += 2*m) {
                int mid = min(i + 2*m - 1, high);
                merge(a, i, mid);
            }
        }

    }

    public static void merge( int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int i = low;
        int j = mid + 1;
        int k = 0;
        int [] temp = new int[high - low + 1];
        while ( i<=mid && j<=high ) {

            if ( arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i<=mid) {
            temp[k++] = arr[i++];
        }
        while ( j<= high ) {

            temp[k++] = arr[j++];
        }

        i = low;
        for( k=0; k < temp.length;){
            arr[i++] = temp[k++];
        }
    }
}