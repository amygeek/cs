package com.dsa.array;

/*
Given a array of integers, in which every elements occurs even number of times except one number
which occurs odd number of times. Find out that number.

Example:

 int[] A = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7 };
Element appearing odd number of times: 5
Approach:

we know that A XOR A = 0 so numbers appearing even number of times will be cancelled out and remaining element will the number which is appearing odd number of times.
 */
public class OddOccuringNumber {
    public static int findNumber(int [] A){
        int x=0;
        for(int i=0;i<A.length;i++){
            x= x^A[i];
        }
        return x;
    }
    public static void main(String[] args) {
        int[] A = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7 };
        System.out.println("Element appearing odd number of times: " + findNumber(A));

    }
}
