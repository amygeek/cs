package com.dsa;

public class Permutation {

    public static int count = 1;

    public static void main(String[] args)
    {
        String str = "abc";
        permutation(str);
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {

        int n = str.length();


        if (n == 0) {
            System.out.println("permutation: " + prefix);
        } else {

            /**
             * "abc
             * permutation("a", "bc")  //str.charAt(0), str.substring(0, 0) + str.substring(1)
             * permutation("b", "ac")  //str.charAt(1), str.substring(0, 1) + str.substring(2)
             * permutation("c", "ab")  //str.charAt(2), str.substring(0, 2) + str.substring(3)
             */

            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1));
            }

        }
    }

}