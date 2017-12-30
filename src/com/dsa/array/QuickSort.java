package com.dsa.array;


public class QuickSort {

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    // Below partition is using Hoare's algorithm.
    int partition(int arr[], int low, int high) {
        int pivot_value = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && arr[i] <= pivot_value) i++;
            while (arr[j] > pivot_value) j--;

            if (i < j) {
                swap(arr, i, j);
            }
            else {
                break;
            }
        }

        arr[low] = arr[j];
        arr[j] = pivot_value;

        return j;
    }

    void quick_sort_rec(int arr[], int low, int high) {
        if (high > low) {
            int pivot_index = partition(arr, low, high);
            quick_sort_rec(arr, low, pivot_index - 1);
            quick_sort_rec(arr, pivot_index + 1, high);
        }
    }

    void quick_sort(int arr[], int size) {
        quick_sort_rec(arr, 0, size - 1);
    }
}
