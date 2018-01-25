package com.dsa.string;

/*
Given two string sequences, write an algorithm to find the length of longest subsequence present in both of them.
 */
public class LongestCommonSubsequence {

    /*
        Start comparing strings in reverse order one character at a time.

        Now we have 2 cases –

        Both characters are same
        add 1 to the result and remove the last character from both the strings and make recursive call to the modified strings.
        Both characters are different
        Remove the last character of String 1 and make a recursive call and remove the last character from String 2 and make a recursive and then return the max from returns of both recursive calls. see example below
        Example:

        Case 1:

        String A: "ABCD", String B: "AEBD"

        res("ABCD", "AEBD") = 1 + res("ABC", "AEB")

        Case 2:

        String A: "ABCDE", String B: "AEBDF"

        res("ABCDE", "AEBDF") = Max(res("ABCDE", "AEBD"), res("ABCD", "AEBDF"))
        Time complexity will O(2n) since we will solving sub problems repeatedly.
     */

    public static int findRec(String A, String B) {
        if (A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int lenA = A.length();
        int lenB = B.length();
        // check if last characters are same
        if (A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
            // Add 1 to the result and remove the last character from both
            // the strings and make recursive call to the modified strings.
            return 1 + findRec(A.substring(0, lenA - 1), B.substring(0, lenB - 1));
        } else {
            // Remove the last character of String 1 and make a recursive
            // call and remove the last character from String 2 and make a
            // recursive and then return the max from returns of both recursive
            // calls
            return Math.max( findRec(A.substring(0, lenA - 1), B.substring(0, lenB)), findRec(A.substring(0, lenA), B.substring(0, lenB - 1)));
        }
    }

    /*
     DP: Bottom-Up and store the solution of the sub problems in a solution array and use it when ever needed
     Start from bottom right corner and track the path and mark the cell from which cell the value is coming
     and whenever you go diagonal ( means last character of both string has matched,
     so we reduce the length of both the strings by 1, so we moved diagonally), mark those cells, this is our answer.


            A   B   C   D   A
         0  0   0   0   0   0
      A  0  1   1   1   1   1
      C  0  1   1   2   2   2
      B  0  1   2   2   2   2
      D  0  1   2   2   3   3
      E  0  1   2   2   3   3
      A  0  1   2   2   3   4


     */
    public static int find(char[] A, char[] B) {

        int[][] res = new int[A.length + 1][B.length + 1];

        String[][] solution = new String[A.length + 1][B.length + 1];

        // if A is null then res of A, B =0
        for (int i = 0; i <= B.length; i++) {
            res[0][i] = 0;
            solution[0][i] = "0";
        }

        // if B is null then res of A, B =0
        for (int i = 0; i <= A.length; i++) {
            res[i][0] = 0;
            solution[i][0] = "0";
        }

        for (int i = 1; i <= A.length; i++) {

            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {

                    res[i][j] = res[i - 1][j - 1] + 1;

                    solution[i][j] = "diagonal";

                } else {

                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);

                    if (res[i][j] == res[i - 1][j]) {
                        solution[i][j] = "top";
                    } else {
                        solution[i][j] = "left";
                    }

                }
            }
        }

        // below code is to just print the result
        String x = solution[A.length][B.length];
        String answer = "";
        int a = A.length;
        int b = B.length;
        while (x != "0") {
            if (solution[a][b] == "diagonal") {
                answer = A[a - 1] + answer;
                a--;
                b--;
            } else if (solution[a][b] == "left") {
                b--;
            } else if (solution[a][b] == "top") {
                a--;
            }
            x = solution[a][b];
        }
        System.out.println(answer);

        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= B.length; j++) {
                System.out.print(" " + res[i][j]);
            }
            System.out.println();
        }

        return res[A.length][B.length];
    }

    public static void main(String[] args) {
        String A = "ACBDEA";
        String B = "ABCDA";
        System.out.println("Longest Commone Sub Sequence Len :" + find(A.toCharArray(), B.toCharArray()));
    }
}