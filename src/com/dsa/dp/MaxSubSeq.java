package com.dsa.dp;
import java.util.ArrayList;
/*
 * Find out the maximum sub-array of non negative numbers from an array.
 The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

 Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

 Example:

 A : [1, 2, 5, -7, 2, 3]
 The two sub-arrays are [1, 2, 5] [2, 3].
 The answer is [1, 2, 5] as its sum is larger than [2, 3]
 NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 NOTE 2: If there is still a tie, then return the segment with minimum starting index
 */
import java.util.*;
public class MaxSubSeq {
    public static ArrayList<Integer> maxSet(ArrayList<Integer> A) {
        ArrayList<Integer> maxRange = new ArrayList<Integer>();
        ArrayList<Integer> currentRange = new ArrayList<Integer>();
        long maxSum = Integer.MIN_VALUE;
        long currentSum = 0;
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) >= 0) {
                currentSum += A.get(i);
                currentRange.add(A.get(i));
                if((maxSum == currentSum && (maxRange.size() < currentRange.size() || maxRange.get(0) > currentRange.get(0)) || currentSum > maxSum ) ) {
                    maxSum = currentSum;
                    maxRange = new ArrayList<>(currentRange);
                }
            } else {
                currentSum = 0;
                currentRange.clear();
            }
        }
        System.out.println("MaxRange : " + maxRange);
        System.out.println("MaxSum : " + maxSum);
        return maxRange;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(5);
        A.add(3);
        A.add(5);
        A.add(-7);
        A.add(2);
        A.add(10);
        A.add(1);

        System.out.println(maxSet(A));
    }
}
