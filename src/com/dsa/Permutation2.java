package com.dsa;

public class Permutation2 {

    // print n! permutation of the characters of the string s (in order)
    public  static void perm1(String s) {
        perm1("", s);
    }

    private static void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1));
            }
        }
    }

    // print n! permutation of the elements of array a (not in order)
    public static void perm2(String s) {
        int n = s.length();
        char[] a = new char[n];
        for (int i = 0; i < n; i++)
            a[i] = s.charAt(i);
        perm2(a, 0, n-1);
    }

    private static void perm2(char[] a, int start, int end) {
        if (start == end) {
            System.out.println(a);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(a, start, i);
            perm2(a, start + 1, end);
            swap(a, start, i);
        }
    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static void main(String[] args) {

        perm1("abc");
        System.out.println();
        perm2("amy");
    }
}
