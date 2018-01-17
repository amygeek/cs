package com.dsa.dp;

public class StairsClimbing {

    public int findWaysRec(int n) {
        if (n < 1) {
            return 0;
        }
        return 1 + findWaysRec(n - 1) + findWaysRec(n - 2) + findWaysRec(n - 3);
    }

    public int findWaysDP(int n, int[] res) {
        if (n < 1) {
            return 0;
        }
        if (res[n] > 0) {
            return res[n];
        }
        res[n] = 1 + findWaysDP(n - 1, res) + findWaysDP(n - 2, res) + findWaysDP(n - 3, res);
        return res[n];
    }

    public static void main(String[] args) {

        int n = 3;
        StairsClimbing s = new StairsClimbing();
        int[] res = new int[n + 1];
        System.out.println(s.findWaysDP(n, res));
    }

}