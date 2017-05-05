package com.dsa;

/**
 * Created by amygeek on 4/24/17.
 */
public class Search {
    // Returns index of key in arr[l..h] if key is present,
    // otherwise returns -1
    public static int search(int arr[], int l, int h, int key)
    {
        if (l > h) return -1;

        int mid = (l+h)/2;
        if (arr[mid] == key) return mid;

        /* If arr[l...mid] is sorted */
        if (arr[l] <= arr[mid])
        {
        /* As this subarray is sorted, we can quickly
           check if key lies in half or other half */
            if (key >= arr[l] && key <= arr[mid]) {
                return search(arr, l, mid - 1, key);
            }

            return search(arr, mid+1, h, key);
        }

    /* If arr[l..mid] is not sorted, then arr[mid... r]
       must be sorted*/
        if (key >= arr[mid] && key <= arr[h]) {
            return search(arr, mid+1, h, key);
        }

        return search(arr, l, mid-1, key);
    }
    public static void main(String[] args) {
        int[] a = { 2, 3, 2, 2, 2, 2, 2, 2 , 2 , 2};

        System.out.println(search(a, 0, a.length - 1, 2));
        System.out.println(search(a, 0, a.length - 1, 3));
        System.out.println(search(a, 0, a.length - 1, 4));
        System.out.println(search(a, 0, a.length - 1, 5));
        System.out.println(search(a, 0, a.length - 1, 8));
    }
}
