package com.dsa.string;

import java.util.Arrays;

/*
Write an algorithm to Print All the Well Ordered Permutations of a Given String.

What is Well Ordered String: When all the alphabets in a string occur in the increasing order irrespective of Lower Case or Upper case.

This is yet another problem in which you we see the power of recursion.

Example :

"Sumit" - Not Well Ordered . 'u' occurred after 'S'.

"Now" - Well Ordered. N<o<W.

 */

public class WellOrderedPermutations {

    // Logic:
    // 1. Get the input sequence
    // 2. Find out all the permutations of a String
    // 3. Before printing if the permutation is well formed.
    char[] A;

    public void wellFormedString(String S) {
        A = S.toCharArray();
        permutation(A, 0);
    }

    public void permutation(char[] A, int left) {
        if (left == A.length) {
            if (isWellFormed(A)) {
                System.out.println(Arrays.toString(A));
            }
            return;
        }
        for (int i = left; i < A.length; i++) {
            swap(i, left);
            permutation(A, left + 1);
            swap(i, left); // backtrack
        }
    }

    public void swap(int a, int b) {
        char temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public boolean isWellFormed(char[] A) {
        boolean wellFormed = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (Character.toLowerCase(A[i]) > Character.toLowerCase(A[i + 1])) {
                wellFormed = false;
                break;
            }
        }
        return wellFormed;
    }

    public static void main(String[] args) {
        String S = "Now";  // [N, o, w] [N, w, o][o, N, w] [o, w, N] [w, o, N] [w, N, o]: [N, o, w] is wellformed
        System.out.println("Given String - " + S);
        WellOrderedPermutations i = new WellOrderedPermutations();
        i.wellFormedString(S);

    }
}