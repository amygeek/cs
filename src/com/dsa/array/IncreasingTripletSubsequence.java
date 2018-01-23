package com.dsa.array;
import java.util.Arrays;
/*
Given an integer array A[1..n], find an instance of i,j,k where 0 < i < j < k <= n and A[i] < A[j] < A[k].

Example :

int arr[] = { 10, 9, 4, 3, 2, 1, 7, 3, 1, 11, 2, 6, 9 };
Output :
Increasing triplets are

1, 7, 11
1, 2, 6
1, 3, 9

likewise you can find more triplets.

O(n)

Create 2 Auxilary Arrays say minArr[] and maxArr[] of the same size as main array
Put minArr[0]=0 and maxArr[maxArr.length-1] =maxArr.length-1
Traverse the main array and fill the minArr array with the index position which has the minimum value so far
Traverse the main array backwords and fill the maxArr array with the index position which has the maximun value so far.
Now Traverse the main array and check for the element with the following condition and print it.
arr[minArr[i]] < arr[i] && arr[maxArr[i]] > arr[i]
 */
public class IncreasingTripletSubsequence {
    // Find a sorted subsequence of size 3 in linear time
    // Given an integer array A[1..n], find an instance of i,j,k where 0 < i < j
    // < k <= n and A[i] < A[j] < A[k].
    public void triplet(int[] arr) {
        
        int n = arr.length;

        int[] minArr = new int[n];
        int[] maxArr = new int[n];
        
        int left = 0;
        int leftVal = arr[0];
        
        int right = n - 1;
        int rightVal = arr[n - 1];

        // traverse the main array and fill the minArr array with the index
        // position which has the minimum value so far
        for (int i = 0; i < n; i++) {
            if (leftVal > arr[i]) {
                left = i;
                leftVal = arr[i];
            }
            minArr[i] = left;
        }

        //System.out.println(leftVal);  // 1
        //System.out.println(Arrays.toString(minArr)); //[0, 1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5]

        // traverse the main array backwords and fill the maxArr array with the
        // index position which has the maximun value so far
        for (int i = n - 1; i >= 0; i--) {
            if (rightVal < arr[i]) {
                right = i;
                rightVal = arr[i];
            }
            maxArr[i] = right;
        }

        //System.out.println(Arrays.toString(maxArr)); //[9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 12, 12, 12] max right index is 12, max right value is 12

        // Now Traverse the main array and check for the element with the
        // following condition and print it.
        // arr[minArr[i]] < arr[i] && arr[maxArr[i]] > arr[i]

        for (int i = 0; i < n; i++) {

            if (arr[minArr[i]] < arr[i] && arr[maxArr[i]] > arr[i]) {
                System.out.println("Triplet " + arr[minArr[i]] + "  " + arr[i] + "  " + arr[maxArr[i]]);
                //return;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 9, 4, 3, 2, 1, 7, 3, 1, 11, 2, 6, 9 };
        IncreasingTripletSubsequence i = new IncreasingTripletSubsequence();
        i.triplet(arr);

    }

}
