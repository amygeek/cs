package com.dsa.array;
import java.util.Arrays;
/*
Given an integer array A[1..n], find an instance of i,j,k where 0 < i < j < k <= n and A[i] < A[j] < A[k].

Example :

int arrA[] = { 10, 9, 4, 3, 2, 1, 7, 3, 1, 11, 2, 6, 9 };
Output :
Increasing triplets are

1, 7, 11
1, 2, 6
1, 3, 9

likewise you can find more triplets.

O(n)

Create 2 Auxilary Arrays say Lmin[] and Rmax[] of the same size as main array
Put Lmin[0]=0 and Rmax[Rmax.length-1] =Rmax.length-1
Traverse the main array and fill the Lmin array with the index position which has the minimum value so far
Traverse the main array backwords and fill the Rmax array with the index position which has the maximun value so far.
Now Traverse the main array and check for the element with the following condition and print it.
arrA[Lmin[i]] < arrA[i] && arrA[Rmax[i]] > arrA[i]
 */
public class IncreasingTripletSubsequence {
    // Find a sorted subsequence of size 3 in linear time
    // Given an integer array A[1..n], find an instance of i,j,k where 0 < i < j
    // < k <= n and A[i] < A[j] < A[k].
    public void triplet(int[] arrA) {
        int[] Lmin = new int[arrA.length];
        int[] Rmax = new int[arrA.length];
        int leftMinIndex = 0;
        int leftMinValue = arrA[0];
        int rightMaxValue = arrA[arrA.length - 1];
        int rightMaxIndex = arrA.length - 1;

        // traverse the main array and fill the Lmin array with the index
        // position which has the minimum value so far
        for (int i = 0; i < arrA.length; i++) {
            if (leftMinValue > arrA[i]) {
                leftMinIndex = i;
                leftMinValue = arrA[i];
            }
            Lmin[i] = leftMinIndex;
        }

        // System.out.println(Arrays.toString(Lmin));

        // traverse the main array backwords and fill the Rmax array with the
        // index position which has the maximun value so far
        for (int i = arrA.length - 1; i >= 0; i--) {
            if (rightMaxValue < arrA[i]) {
                rightMaxIndex = i;
                rightMaxValue = arrA[i];
            }
            Rmax[i] = rightMaxIndex;
        }

        //System.out.println(Arrays.toString(Rmax));

        // Now Traverse the main array and check for the element with the
        // following condition and print it.
        // arrA[Lmin[i]] < arrA[i] && arrA[Rmax[i]] > arrA[i]

        for (int i = 0; i < arrA.length; i++) {
            if (arrA[Lmin[i]] < arrA[i] && arrA[Rmax[i]] > arrA[i]) {
                System.out.println("Triplet " + arrA[Lmin[i]] + "  " + arrA[i]
                        + "  " + arrA[Rmax[i]]);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int arrA[] = { 10, 9, 4, 3, 2, 1, 7, 3, 1, 11, 2, 6, 9 };
        IncreasingTripletSubsequence i = new IncreasingTripletSubsequence();
        i.triplet(arrA);

    }

}
