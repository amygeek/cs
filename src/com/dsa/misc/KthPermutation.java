package com.dsa.misc;

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;


/* Name of the class has to be "Main" only if the class is public. */
class KthPermutation {

    static public void findPermutation(int n, int k) {
        int[] numbers = new int[n];
        int[] indices = new int[n];

        // initialise the numbers 1, 2, 3...
        for (int i = 0; i < n; i++)
            numbers[i] = i + 1;

        int divisor = 1;
        for (int place = 1; place <= n; place++)
        {
            if((k / divisor) == 0)
                break;	// all the remaining indices will be zero

            // compute the index at that place:
            indices[n-place] = (k / divisor) % place;
            divisor *= place;
        }

        // print out the indices:
        // System.out.println(Arrays.toString(indices));

        // permute the numbers array according to the indices:
        for (int i = 0; i < n; i++) {
            int index = indices[i] + i;

            // take the element at index and place it at i, moving the rest up
            if(index != i)
            {
                int temp = numbers[index];
                for(int j = index; j > i; j--)
                    numbers[j] = numbers[j-1];
                numbers[i] = temp;
            }
        }

        System.out.println(Arrays.toString(numbers));
    }

    public static void main (String[] args) throws java.lang.Exception {
        // your code goes here
        for(int i = 0; i < 6; i++)
            findPermutation(3, i);

        findPermutation(100, 10000000-1);
    }
}