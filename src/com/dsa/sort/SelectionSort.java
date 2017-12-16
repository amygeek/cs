package com.dsa.sort;

// Java program for implementation of Selection Sort
public class SelectionSort {

    public static final void swap (int[]a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void sort(int[] arr, int n) {

        // One by one move boundary of unsorted subarray
        // outer loop: loop index is 1 digit less than array length because the inner loop index is 1 + the outer index
        for (int i = 0; i < n-1; i++) {

            // set minimum to this position
            int min = i;

            // check the rest of the array to see if anything is smaller
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // if the minimum isn't in the position, swap it
            if (i != min){
                swap(arr, i, min);
            }
        }
    }

    public void sortRec( int[] arr, int i, int n) {

        int min = i;
        for (int j=i+1; j<n; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        if ( i != min ) {
            swap(arr, i, min);
        }

        if ( i + 1 < n ) {
            sortRec( arr, i+1, n);
        }
    }

    // Prints the array
    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; ++i) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    // Driver code to test above
    public static void main(String[] args) {



        SelectionSort ob = new SelectionSort();
        int[] arr = {200,25,82,22,11};

        System.out.println("Un-sorted array: " );
        ob.printArray(arr);

        ob.sortRec(arr, 0, arr.length);

        System.out.println("Sorted array: " );
        ob.printArray(arr);
    }
}