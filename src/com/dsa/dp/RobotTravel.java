package com.dsa.dp;

/*
Given two dimensional matrix, write an algorithm to count all possible paths from top left corner to bottom-right corner.
You are allowed to move only in two directions, move right OR move down. There are few obstructions as well,
means few cells are blocked and you cannot travel that cell.

Many times this problem is being referred as “Robot Travel Problem“. Given a 2d matrix, how many ways
a robot can travel from top left corner to bottom right corner and there are few cells in which robot cannot travel.
 */
public class RobotTravel {

    public int count(int [][] arr, int row, int col){
        //base case
        //check if last row OR column is reached since after that only one path
        if(row == arr.length - 1 && col == arr.length - 1){
            return 1;
        }

        int left =0;
        int down = 0;
        if(row != arr.length - 1 && arr[row+1][col] != -1 ){
            left = count(arr, row+1, col);
        }
        if( col != arr.length - 1 && arr[row][col+1] != -1){
            down = count(arr, row, col+1);
        }
        return left + down;
    }

    public int countDP(int [][] arr){

        int result [][] = arr;

        for (int i = 1; i < arr.length ; i++) {
            for (int j = 1; j < arr.length ; j++) {

                if( result[i][j] != -1 ){
                    result[i][j] = 0;

                    if ( result[i-1][j] > 0 ) {
                        result[i][j] += result[i-1][j];
                    }

                    if ( result[i][j-1] > 0 ) {
                        result[i][j] += result[i][j-1];
                    }

                }
            }
        }

        return result[arr.length-1][arr.length-1];
    }

    public static void main(String[] args) {

//        int arr [][] = {{1,  1, 1},
//                        {1, -1, 1},
//                        {1,  1, 1}};   // path 2

//        int arr [][] = {{1,  1, 1},
//                        {1,  1, 1},
//                        {1, -1, 1}};   // path 3

        int arr [][] = {{1,  1, 1},
                        {1, -1, 1},
                        {1, -1, 1}};   // path 1

        RobotTravel noOfPaths = new RobotTravel();
        System.out.println("No Of Path (Recursion): " + noOfPaths.count( arr, 0, 0));
        System.out.println("No Of Path (DP) " + noOfPaths.countDP( arr ));
    }
}