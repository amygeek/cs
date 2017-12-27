package com.dsa;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class MakeZero {

    static void make_zeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        Set<Integer> zero_rows = new HashSet<Integer>();
        Set<Integer> zero_cols = new HashSet<Integer>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == 0) {
                    if (!zero_rows.contains(i)) {
                        zero_rows.add(i);
                    }

                    if (!zero_cols.contains(j)) {
                        zero_cols.add(j);
                    }
                }
            }
        }

        for (int r : zero_rows) {
            for (int c = 0; c < cols; ++c) {
                matrix[r][c] = 0;
            }
        }

        for (int c : zero_cols) {
            for (int r = 0; r < rows; ++r) {
                matrix[r][c] = 0;
            }
        }
    }

    public static void main(String[] arg) {
        int[][] m = {{1,7, 4, 5}, {3, 0, 9, 10}, {11, 12, 0, 19}, {6, 2, 8, 28}};

        make_zeroes(m);

        //[1, 0, 0, 5][0, 0, 0, 0][0, 0, 0, 0][6, 0, 0, 28]
        for(int i=0; i<m.length; i++) {
            System.out.print(Arrays.toString(m[i]));
        }
    }
}
