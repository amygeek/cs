package com.dsa.dp;
// Java program to find nth ugly number
import java.lang.Math;

class UglyNumber
{
    /* Function to get the nth ugly number*/
    int getNthUglyNo(int n) {

        int ugly[] = new int[n];  // To store ugly numbers

        int i2 = 0, i3 = 0, i5 = 0;
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        int nextUglyNum = 1;

        ugly[0] = 1;

        for(int i = 1; i < n; i++) {

            nextUglyNum = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));

            ugly[i] = nextUglyNum;

            if (nextUglyNum == nextMultipleOf2) {
                i2++;
                nextMultipleOf2 = ugly[i2] * 2;
            }

            if (nextUglyNum == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = ugly[i3] * 3;
            }
            if (nextUglyNum == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = ugly[i5] * 5;
            }
        } /*End of for loop (i=1; i<n; i++) */
        return nextUglyNum;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        int n = 150;
        UglyNumber obj = new UglyNumber();
        System.out.println(obj.getNthUglyNo(n));  //5832
    }
}