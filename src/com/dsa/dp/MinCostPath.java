package com.dsa.dp;

/*
We will fill this matrix in Bottom-up manner.

Given: arrA[][].

At every cell, we have two options (go right or down) and we will choose the minimum of these two.

So for any i,j cell

res[i][j] = cost[0][j] if i=0 ,
first row = cost[i][0] if j=0,
first column = cost[i][j] + Min(res[i-1],[j] , res[i][j-1]) if i>0 && j>0

See the code for better Explanation.
Time Complexity: O(n2).
 */
public class MinCostPath {
    
    public static int min(int a, int b, int c ) {
        return Math.min( Math.min(a, b), c );
    }
    public static int find(int[][] cost) {
        int mLen = cost.length;
        int[][] res = new int[mLen][mLen];

        res[0][0] = cost[0][0];
        // fill the first row
        for (int i = 1; i < mLen; i++) {
            res[0][i] = cost[0][i] + res[0][i - 1];
        }

        // fill the first column
        for (int i = 1; i < mLen; i++) {
            res[i][0] = cost[i][0] + res[i - 1][0];
        }

        // path will be either from top or left, choose which ever is minimum
        for (int i = 1; i < mLen; i++) {
            for (int j = 1; j < mLen; j++) {
                res[i][j] = cost[i][j] + Math.min(res[i - 1][j], res[i][j - 1]);
                //if includes diagonal cell, we need to check res[i-1][j-1]
                //res[i][j] = cost[i][j] + min(res[i-1][j-1], res[i-1][j],res[i][j-1]);
            }
        }
        return res[mLen - 1][mLen - 1];
    }

    public static void main(String[] args) {
        int[][] cost = {
                {1, 7, 9, 2},
                {8, 6, 3, 2},
                {1, 6, 7, 8},
                {2, 9, 8, 2}};
        System.out.println("Minimum Cost Path " + find(cost));
    }
}