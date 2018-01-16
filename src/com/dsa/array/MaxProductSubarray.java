package com.dsa.array;

/*
Given an array that contains both positive and negative integers,
find the product of the maximum product subarray. Expected Time complexity is O(n) and only O(1) extra space can be used.

Examples:

Input: arr[] = {6, -3, -10, 0, 2}
Output:   180  // The subarray is {6, -3, -10}

Input: arr[] = {-1, -3, -10, 0, 60}
Output:   60  // The subarray is {60}

Input: arr[] = {-2, -3, 0, -2, -40}
Output:   80  // The subarray is {-2, -40}
 */
class MaxProductSubarray {

    // Utility functions to get minimum of two integers
    static int min (int x, int y) {
        return x < y? x : y; 
    }

    // Utility functions to get maximum of two integers
    static int max (int x, int y) {
        return x > y? x : y; 
    }

    /* Returns the product of max product subarray.
       Assumes that the given array always has a subarray
       with product more than 1 */
    static int maxSubarrayProduct(int arr[])
    {
        int n = arr.length;
        // max positive product ending at the current position
        int maxEnd = 1;

        // min negative product ending at the current position
        int minEnd = 1;

        // Initialize overall max product
        int max = 1;

        /* Traverse through the array. Following
           values are maintained after the ith iteration:
           maxEnd is always 1 or some positive product ending with arr[i]
           minEnd is always 1 or some negative product ending with arr[i] */

        for (int i = 0; i < n; i++)
        {
            /* If this element is positive, update maxEnd.
                Update minEnd only if minEnd is
                negative */
            if (arr[i] > 0) {
                maxEnd = maxEnd * arr[i];
                minEnd = min (minEnd * arr[i], 1);
            } else if (arr[i] == 0) {
                /* If this element is 0, then the maximum product cannot
               end here, make both maxEnd and minEnd 0
               Assumption: Output is always greater than or equal to 1. */
                maxEnd = 1;
                minEnd = 1;
            } else {
            
               /* If element is negative. This is tricky
                   maxEnd can either be 1 or positive.
                   minEnd can either be 1 or negative.
                   next minEnd will always be prev.
                   maxEnd * arr[i]
                   next maxEnd will be 1 if prev
                   minEnd is 1, otherwise
                   next maxEnd will be prev minEnd * arr[i] 
                */
                           
                int temp = maxEnd;
                maxEnd = max (minEnd * arr[i], 1);
                minEnd = temp * arr[i];
            }

            // update max, if needed
            if (max <  maxEnd) {
                max  =  maxEnd;
            }
                
        }

        return max;
    }

    static int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
    public static void main (String[] args) {

        int arr[] = {6, -3, -10, 0, 2};
        System.out.println("Maximum Sub array product is "+ maxSubarrayProduct(arr));
        System.out.println("Maximum Sub array product is "+ maxProduct(arr));
    }
}