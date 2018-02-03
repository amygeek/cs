package com.dsa.dp;

/*
Given two dimensional matrix, write an algorithm to find out the snake sequence which has the maximum length.
There could be many snake sequence in the matrix, you need to return the one with the maximum length.
Travel is allowed only in two directions, either go right OR go down.

What is snake sequence: Snake sequence can be made if number in adjacent right cell or number in the adjacent down cell
is either +1 or -1 from the number in the current cell.
 */
public class SnakeSequence {

    public int getMaxSequence(int [][] matrix){

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxLenth =1;
        int maxRow = 0;
        int maxCol = 0;

        //create result matrix
        int [][] result = new int [rows][cols];

        //if no sequence is found then every cell itself is a sequence of length 1
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                result[i][j] =1;
            }
        }

        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if(i!=0 || j!=0){
                    //check from left
                    if(i>0 && Math.abs(matrix[i][j]-matrix[i-1][j])==1){
                        result[i][j] = Math.max(result[i][j], result[i-1][j]+1);
                        if(maxLenth<result[i][j]){
                            maxLenth = result[i][j];
                            maxRow = i;
                            maxCol = j;
                        }
                    }

                    //check from top
                    if(j>0 && Math.abs(matrix[i][j]-matrix[i][j-1])==1){
                        result[i][j] = Math.max(result[i][j], result[i][j-1]+1);
                        if(maxLenth<result[i][j]){
                            maxLenth = result[i][j];
                            maxRow = i;
                            maxCol = j;
                        }
                    }
                }
            }
        }

        //Now we will check the max entry in the result[][].
        System.out.println("Max Snake Sequence : " + maxLenth);
        printPath(matrix, result, maxLenth, maxRow, maxCol);
        return 0;
    }

    public void printPath(int [][] matrix, int [][] result, int maxLength, int maxRow, int maxCol){
        int len =  maxLength;
        while(maxLength>=1){
            System.out.print(" - " + matrix[maxRow][maxCol]);
            if(maxRow>0 && Math.abs(result[maxRow-1][maxCol]-result[maxRow][maxCol])==1){
                maxRow--;
            }else if(maxCol>0 && Math.abs(result[maxRow][maxCol-1]-result[maxRow][maxCol])==1){
                maxCol--;
            }
            maxLength--;
        }
    }


    public static void main(String[] args) {
        int arrA [][] = {{1, 2, 1, 2},
                {7, 7, 2, 5},
                {6, 4, 3, 4},
                {1, 2, 2, 5}};
        SnakeSequence snakeSequence = new SnakeSequence();
        snakeSequence.getMaxSequence(arrA);
    }
}