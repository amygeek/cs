package com.dsa;

/**
 * Problem: Maximal Value of Gifts
 * A board has n*m cells, and there is a gift with some value (value is greater than 0) in every cell.
 * You can get gifts starting from the top-left cell, and move right or down in each step,
 * and finally reach the cell at the bottom-right cell. What’s the maximal value of gifts you can get from the board?
 */
public class GetMaxValue {

    public static int getMaxValue(int[][] values) {
        int rows = values.length;
        int cols = values[0].length;

        int[] maxValues = new int[cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;

                if(i > 0) {
                    up = maxValues[j];
                }

                if(j > 0) {
                    left = maxValues[j - 1];
                }

                maxValues[j] = Math.max(left, up) + values[i][j];
            }
        }

        return maxValues[cols - 1];
    }

    public static void main(String[] args) {
        int[][] values = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };

        //output 53
        System.out.println(getMaxValue(values));

        int[][] values2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        //output 29
        System.out.println(getMaxValue(values2));
    }
}