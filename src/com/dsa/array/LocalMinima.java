package com.dsa.array;

/*
 Objective:  Given an array of integers write an algorithm to find the local minima.

 Local Minima: An element is considered as local minima if it is less than both of its neighbors (if neighbors exist).

 Example:

 let [] arr = {11, 4, 2, 5, 11, 13, 5};
 Output: Local Minima is: 2

 let []arr = {1,2,3,4};
 Output: 1

 let []arr = {3};
 Output: 3

 let []arr = {6,4};
 Output: 4
 NOTE: There could be many local minimas, we need to find any one.

 Binary Search Approach:

 Check if mid element is smaller than its left and right neighbors.
 If left neighbor is less than the mid element then make a recursive call to the left half of the array.
 (There will be at least one local minima in the left half, take few examples to check)
 If right neighbor is less than the mid element then make a recursive call to the right half of the array.
 Time Complexity – O(logn)
 */
public class LocalMinima {
    public static int findLocalMinima( int[] arr, int left, int right ) {
        int mid = (left + right ) / 2;
        int size = arr.length;
        if ( ( mid == 0 || arr[mid] < arr[mid-1] ) && ( mid == size -1 || arr[mid] < arr[mid + 1])) {
            return arr[mid];
        } else if ( mid > 0 && arr[mid] > arr[mid-1]) {
            return findLocalMinima(arr, left, mid);
        } else {
            return findLocalMinima(arr, mid+1, right);
        }
    }
    public static void main (String[] args) {
        int[] arr = {11, 4, 2, 5, 11, 13, 5};
        int num = findLocalMinima(arr, 0, arr.length);
        System.out.println(num);
    }
}
