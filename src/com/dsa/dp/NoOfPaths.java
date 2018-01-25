package com.dsa.dp;

/*
Given two dimensional matrix, write an algorithm to count all possible paths from top left corner to bottom-right corner.
You are allowed to move only in two directions, move right OR move down.
 */
public class NoOfPaths {

    public int count(int [][] arr, int row, int col){
        //base case
        //check if last row OR column is reached since after that only one path
        //is possible to reach to the bottom right corner.
        if( row == arr.length - 1 || col == arr.length - 1){
            return 1;
        }
        return count( arr, row + 1, col ) + count( arr, row, col + 1 );
    }

    public int countDP( int [][] arr ) {

        int n = arr.length;

        int result [][] = new int[n][n];

        //base case: if we have one cell then there is only one way
        result[0][0] = 1;

        //no of paths to reach in any cell in first row = 1
        for (int i = 0; i < n ; i++) {
            result[0][i] = 1;
        }

        //no of paths to reach in any cell in first col = 1
        for (int i = 0; i < n ; i++) {
            result[i][0] = 1;
        }

        for (int i = 1; i < n ; i++) {
            for (int j = 1; j <n ; j++) {
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }

        return result[n-1][n-1];
    }

    public static void main(String[] args) {
        int arr [][] = {{1,1,1},
                         {1,1,1},
                         {1,1,1}};
        NoOfPaths noOfPaths = new NoOfPaths();
        System.out.println("No Of Path (Recursion): " + noOfPaths.count( arr, 0, 0));
        System.out.println("No Of Path (DP): " + noOfPaths.countDP( arr ));
    }
}