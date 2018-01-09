package com.dsa.dp;
import java.util.Arrays;

/**
 * Given an array with non negative numbers, divide the array into two parts such that the average of both the parts is equal.
 Return both parts (If exist).
 If there is no solution. return an empty list.
 Input:
 [1 7 15 29 11 9]

 Output:
 [9 15] [1 7 11 29]

 The average of part is (15+9)/2 = 12,
 average of second part elements is (1 + 7 + 11 + 29) / 4 = 12

 NOTE 1: If a solution exists, you should return a list of exactly 2 lists of integers A and B which follow the following condition :
        numElements in A <= numElements in B
        If numElements in A = numElements in B, then A is lexicographically smaller than B
 NOTE 2: If multiple solutions exist, return the solution where length(A) is minimum. If there is still a tie,
        return the one where A is lexicographically smallest.
 NOTE 3: Array will contain only non negative numbers.
 */
public class EqualAveragePartition {


    // Returns true if arr[] can be partitioned in two subsets of
    // equal sum, otherwise false
    static boolean canPartition (int arr[], int n) {
        int sum = 0;
        int i, j;

        // Caculcate sun of all elements
        for (i = 0; i < n; i++)
            sum += arr[i];

        if (sum%2 != 0)
            return false;

        boolean part[][]=new boolean[sum/2+1][n+1];

        // initialize top row as true
        for (i = 0; i <= n; i++)
            part[0][i] = true;

        // initialize leftmost column, except part[0][0], as 0
        for (i = 1; i <= sum/2; i++)
            part[i][0] = false;

        // Fill the partition table in botton up manner
        for (i = 1; i <= sum/2; i++)
        {
            for (j = 1; j <= n; j++)
            {
                part[i][j] = part[i][j-1];
                if (i >= arr[j-1]) {
                    part[i][j] = part[i][j] || part[i - arr[j-1]][j-1];
                }

            }
        }
        /*
        // uncomment this part to print table
        for (i = 0; i <= sum/2; i++)
        {
            for (j = 0; j <= n; j++) {
                System.out.print(part[i][j] + " ");
            }

            System.out.println("\n");
        }
        */
        return part[sum/2][n];
    }

    /*Driver function to check for above function*/
    public static void main (String[] args) {
        int arr[] = {3, 1, 1, 2, 2,1};
        int n = arr.length;
        if (canPartition(arr, n) == true)
            System.out.println("Can be divided into two subsets of equal sum");
        else
            System.out.println("Can not be divided into two subsets of equal sum");

    }
}