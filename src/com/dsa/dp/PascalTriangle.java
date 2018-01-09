package com.dsa.dp;

import java.util.*;

public class PascalTriangle {

    // A O(n^2) time and O(n^2) extra space method for Pascal's Triangle
    public static void printPascal(int n) {
        int arr[][] = new int [n][n]; // An auxiliary array to store generated pscal triangle values

        // Iterate through every line and print integer(s) in it
        for (int line = 0; line < n; line++) {
            // Every line has number of integers equal to line number
            for (int i = 0; i <= line; i++) {
                // First and last values in every row are 1
                if (line == i || i == 0) {
                    arr[line][i] = 1;
                } else {
                    // Other values are sum of values just above and left of above
                    arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
                }
                System.out.print(arr[line][i]);
            }
            System.out.println("\n");
        }
    }

    /****************************************************
        C(line, i)   = line! / ( (line-i)! * i! )
        C(line, i-1) = line! / ( (line - i + 1)! * (i-1)! )
        We can derive following expression from above two expressions.
        C(line, i) = C(line, i-1) * (line - i + 1) / i

        So C(line, i) can be calculated from C(line, i-1) in O(1) time

        A O(n^2) time and O(1) extra space function for Pascal's Triangle
     ****************************************************/
    public static void printPascal2 (int n)
    {
        for (int line = 1; line <= n; line++)
        {
            int C = 1;  // used to represent C(line, i)
            for (int i = 1; i <= line; i++)
            {
                System.out.print(C);  // The first value in a line is always 1
                C = C * (line - i) / i;
            }
            System.out.println("\n");
        }
    }
    /*
    Given an index k, return the kth row of the Pascal's triangle. For example, when k = 3, the row is [1,3,3,1].
     */
    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (rowIndex < 0)
            return result;

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }
    public static void main(String[] args) {
        printPascal2(4);
        List ls = getRow(4);
        System.out.println(ls);
    }
}
